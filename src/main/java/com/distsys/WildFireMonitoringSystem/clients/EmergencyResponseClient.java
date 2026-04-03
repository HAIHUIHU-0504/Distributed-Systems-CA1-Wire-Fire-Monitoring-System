package com.distsys.WildFireMonitoringSystem.clients;
import javax.jmdns.JmDNS;
import java.net.URL;
import java.io.IOException;
import com.distsys.WildFireMonitoringSystem.naming.JmDNSDiscovery;

import grpc.EmergencyResponseService.*;
import grpc.EmergencyResponseService.EmergencyResponseServiceGrpc.EmergencyResponseServiceBlockingStub;
import grpc.EmergencyResponseService.EmergencyResponseServiceGrpc.EmergencyResponseServiceStub  ;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class EmergencyResponseClient {
    // a non-blocking stub to make an asynchronous call
    private static EmergencyResponseServiceStub asyncStub;

    // a blocking stub to make synchronous calls
    private static EmergencyResponseServiceBlockingStub syncStub;
    public static void main(String[] args) {
        JmDNSDiscovery  erpDiscovery = new JmDNSDiscovery("_grpc._tcp.local.", "WildFireEmergencyResponseService");
        ManagedChannel erpChannel = null;
        try {
            System.out.println("Searching for gRPC service...");
            String url = erpDiscovery.discoverService(10000);
            
            if (url == null) {
                System.out.println("Could not discover service. Exiting...");
                erpDiscovery.close();
                return;
            }

            System.out.println("Connecting to  Emergency Response service at url:  " + url);

                URL parsedUrl = new URL(url);
                String host = parsedUrl.getHost();
                int port = parsedUrl.getPort();;
    
                System.out.println("\nConnecting to gRPC Service at " + host + ":" + port + "...");

         erpChannel = ManagedChannelBuilder
                    .forAddress(host, port)
                    .usePlaintext()
                    .build();

        // Create a blocking stub for unary calls
        syncStub = EmergencyResponseServiceGrpc.newBlockingStub(erpChannel);
        // Activate sprinklers in Zone A
        activateSprinklers("Zone A", true);

        // Create an asynchronous stub for bi-directional streaming calls
        asyncStub = EmergencyResponseServiceGrpc.newStub(erpChannel);
        // Start monitoring device status
        monitorDeviceStatus();

        // Keep the client running to receive streaming responses
        Thread.sleep(30000); // Run for 30 seconds
        erpChannel.shutdown();
        erpDiscovery.close();

        } catch (Exception e) { 
            e.printStackTrace();
            if (erpDiscovery != null) {
        try {            
            erpDiscovery.close();
        } catch (IOException ioe) {
            System.err.println("Error while closing JmDNS: " + ioe.getMessage());
        }
    
            }    
    }
}
    private static void activateSprinklers(String location, boolean activate) {
        System.out.println((activate ? "Activating" : "Deactivating") + " sprinklers in " + location + "...");
        // Create a request message
        ActionRequest request = ActionRequest.newBuilder()
                .setLocation(location)
                .setActivate(activate)
                .build();
        // Make a unary call to the server
        ActionResponse response = syncStub.activateSprinklers(request);
        // Print the response
        System.out.println("Response: " + response.getMessage());
    }

    /**
     * 2. BI-DIRECTIONAL STREAMING: devices health status monitoring
     */
    public static void monitorDeviceStatus() {
        System.out.println(">>> turning on device status monitoring...");

        // define a response observer to handle incoming messages from the server (from server receive)
        StreamObserver<DeviceStatusResponse> responseObserver = new StreamObserver<DeviceStatusResponse>() {
            @Override
            public void onNext(DeviceStatusResponse value) {
                System.out.println(" device status ID: " + value.getDeviceID() + " | current status: " + value.getStatus());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("monitorDeviceStatus error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("server completed the stream.");
            }
        };

        // 2. call the bi-directional streaming method, providing the response observer to handle server responses, and get a request observer to send messages to the server (to server send)
        StreamObserver<DeviceHealthRequest> requestObserver = asyncStub.monitorDeviceStatus(responseObserver);

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

}

