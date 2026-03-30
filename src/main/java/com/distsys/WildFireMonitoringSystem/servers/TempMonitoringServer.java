package com.distsys.WildFireMonitoringSystem.servers;

import grpc.TempMonitoringService.*;
import grpc.TempMonitoringService.TempMonitoringServiceGrpc.TempMonitoringServiceImplBase;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;
import java.util.logging.Logger;

import com.distsys.WildFireMonitoringSystem.mockDataBase.TemperatureLocationMap;
import com.distsys.WildFireMonitoringSystem.naming.JmDNSRegistration;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
;


public class TempMonitoringServer extends TempMonitoringServiceImplBase {
    private static final Logger logger = Logger.getLogger(TempMonitoringServer.class.getName());
    private static TemperatureLocationMap tempDatabase = new TemperatureLocationMap();
    public static void main(String[] args){
        TempMonitoringServer TempServer = new TempMonitoringServer();
        int port = 50051;

        try {
            // Start gRPC Server
            Server server = ServerBuilder.forPort(port)
            .addService(TempServer)
            .build()
            .start();
            logger.info("Server started, listening on " + port);
            System.out.println("Temperature monitoring Server started, listening on " + port);		   
            
            server.awaitTermination();
            
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

// ------------ gRPC Method Implementations ------------
    @Override
    public void getCurrentTemperature(LocationRequest request, StreamObserver<TemperatureResponse> responseObserver)    {
        String locationID = request.getLocationID();
        // Simulate temperature retrieval based on locationID
        System.out.println("Received temperature request for location: " + request.getLocationID());
        // retrieve temperature value from the database
        Integer tempValue = tempDatabase.getCurrentTemperatureByLocation(locationID);
        if (tempValue == null) {
            System.out.println("Location not found: " + locationID);
            tempValue = -999; // default value for unknown location
        }
        // Builder for response
        TemperatureResponse response = TemperatureResponse.newBuilder()
                .setTempValue(tempValue)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    @Override
    public void monitorTemperature(LocationRequest request, StreamObserver<TemperatureResponse> responseObserver)    
    {
        String locationID = request.getLocationID();
        System.out.println("Starting continuous monitor for: " + locationID);
        //retrieve temperature history for the location from the database
        List<Integer> history = tempDatabase.getAllTemperaturesByLocation(locationID);
        for (int i = 0; i <= history.size() - 1; i++) { 
            // get each temperature value for the location
            int tempValue = history.get(i); 

            TemperatureResponse response = TemperatureResponse.newBuilder()
                    .setTempValue(tempValue)
                    .build();

            responseObserver.onNext(response);
            System.out.println("Sent reading " + (i) + " for " + request.getLocationID());

            try {
                Thread.sleep(2000); // Simulate delay between readings
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        responseObserver.onCompleted();
    }   



}
