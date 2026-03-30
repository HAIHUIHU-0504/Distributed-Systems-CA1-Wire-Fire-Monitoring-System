package com.distsys.WildFireMonitoringSystem.clients;

import grpc.TempMonitoringService.*;
import grpc.TempMonitoringService.TempMonitoringServiceGrpc.TempMonitoringServiceBlockingStub;

import grpc.RiskEvaluateService.*;
import grpc.RiskEvaluateService.RiskEvaluateServiceGrpc.RiskEvaluateServiceBlockingStub;

import grpc.EmergencyResponseService.*;
import grpc.EmergencyResponseService.EmergencyResponseServiceGrpc.EmergencyResponseServiceBlockingStub;
import grpc.EmergencyResponseService.EmergencyResponseServiceGrpc.EmergencyResponseServiceStub  ;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Iterator;

public class WildFireMonitoringClient {
    // a blocking stub to make synchronous calls
    private static TempMonitoringServiceBlockingStub syncTMStub;
    private static RiskEvaluateServiceBlockingStub syncREStub;
    private static EmergencyResponseServiceBlockingStub syncERPStub;
    private static EmergencyResponseServiceStub asyncERPStub;

    public static void main(String[] args) {

//---------------------- channel to temperature monitoring server ----------------------
        ManagedChannel tempChannel = ManagedChannelBuilder
                    .forAddress("localhost", 50051)
                    .usePlaintext()
                    .build();
        // Create a blocking stub for unary and server streaming calls
        syncTMStub = TempMonitoringServiceGrpc.newBlockingStub(tempChannel);

        // Get current temperature for Zone A
        getCurrentTemperature("Zone A");
        // Get temperature history for Zone A
        getTemperatureHistory("Zone A");

// ---------------------- channel to risk evaluation server ----------------------
        ManagedChannel riskChannel = ManagedChannelBuilder
                    .forAddress("localhost", 50052)
                    .usePlaintext()
                    .build();
        // Create a blocking stub for unary and server streaming calls
        syncREStub = RiskEvaluateServiceGrpc.newBlockingStub(riskChannel);

        // Evaluate risk for Zone A with a temperature of 21°C
        evaluateRisk("Zone A", 21);

// ---------------------- channel to emergency response server ----------------------
        ManagedChannel erpChannel = ManagedChannelBuilder
                    .forAddress("localhost", 50053)
                    .usePlaintext()
                    .build();

        // Create a blocking stub for unary calls
        syncERPStub = EmergencyResponseServiceGrpc.newBlockingStub(erpChannel);
        // Activate sprinklers in Zone A
        activateSprinklers("Zone A", true);

        // Create an asynchronous stub for bi-directional streaming calls
        asyncERPStub = EmergencyResponseServiceGrpc.newStub(erpChannel);
    }


// ---------------------- Methods to emergency response server ----------------------    
    private static void activateSprinklers(String location, boolean activate) {
        System.out.println((activate ? "Activating" : "Deactivating") + " sprinklers in " + location + "...");
        // Create a request message
        ActionRequest request = ActionRequest.newBuilder()
                .setLocation(location)
                .setActivate(activate)
                .build();
        // Make a unary call to the server
        ActionResponse response = syncERPStub.activateSprinklers(request);
        // Print the response
        System.out.println("Response: " + response.getMessage());
    }

    /**
     * 2. BI-DIRECTIONAL STREAMING: devices health status monitoring
     */
    public void monitorDeviceStatus() {
        System.out.println(">>> turning on device status monitoring...");

        // define a response observer to handle incoming messages from the server (from server receive)
        StreamObserver<DeviceStatusResponse> responseObserver = new StreamObserver<DeviceStatusResponse>() {
            @Override
            public void onNext(DeviceStatusResponse value) {
                System.out.println(" device status ID: " + value.getDeviceID() + " | current status: " + value.getStatus());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("监控流出错: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("server completed the stream.");
            }
        };

        // 2. call the bi-directional streaming method, providing the response observer to handle server responses, and get a request observer to send messages to the server (to server send)
        StreamObserver<DeviceHealthRequest> requestObserver = asyncERPStub.monitorDeviceStatus(responseObserver);

        try {
            String[] myDevices = {"Sprinkler_A1", "Sensor_B2", "Pump_Main"};
            for (String id : myDevices) {
                System.out.println("sending health check for device: " + id);
                requestObserver.onNext(DeviceHealthRequest.newBuilder().setDeviceID(id).build());
                Thread.sleep(1000); 
            }
        } catch (InterruptedException e) {
            requestObserver.onError(e);
        }

        requestObserver.onCompleted();
    }



// ---------------------- Methods to temperature monitoring server ----------------------
    // Get current temperature for Zone A
    private static void getCurrentTemperature(String location) {
        System.out.println("Getting " + location + " current temperature ...");
        // Create a request message
        LocationRequest request = LocationRequest.newBuilder()
                .setLocationID(location)
                .build();
        // Make a unary call to the server
        TemperatureResponse response = syncTMStub.getCurrentTemperature(request);
        // Print the response
        System.out.println("Current temperature in " + location + ": " + response.getTempValue() + "°C");
    }

    // Get temperature history for Zone A
    private static void getTemperatureHistory(String location) {
        System.out.println("Getting " + location + " temperature history ...");
        // Create a request message
        LocationRequest request = LocationRequest.newBuilder()
                .setLocationID(location)
                .build();
        // Make a server streaming call to the server
        Iterator<TemperatureResponse> responses = syncTMStub.monitorTemperature(request);
        // Print the responses
        while (responses.hasNext()) {
            TemperatureResponse response = responses.next();
            System.out.println("Temperature in " + location + ": " + response.getTempValue() + "°C" );
        }
    }

// ---------------------- Methods to risk evaluation server ----------------------
     private static void evaluateRisk(String location, int temp) {
        System.out.println("Evaluating risk for " + location + " with temperature: " + temp + "°C...");
        // Create a request message
        EnvironmentalData request = EnvironmentalData.newBuilder()
                .setLocationID(location)
                .setTempValue(temp)
                .build();
        // Make a unary call to the server
        RiskAssessment response = syncREStub.evaluateRisk(request);
        // Print the response
        System.out.println("Risk level in " + location + ": " + response.getRiskLevel() + " - " + response.getMessage());
    }
}
 