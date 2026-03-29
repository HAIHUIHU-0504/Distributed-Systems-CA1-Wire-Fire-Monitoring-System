package com.distsys.wire_fire_monitoring_system;

import grpc.TempMonitoringService.*;
import grpc.TempMonitoringService.TempMonitoringServiceGrpc.TempMonitoringServiceImplBase;

import java.io.IOException;
import java.util.Random;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import io.grpc.stub.StreamObserver;


public class TempMonitoringServer extends TempMonitoringServiceImplBase {
    private static final Logger logger = Logger.getLogger(TempMonitoringServer.class.getName());

    public static void main(String[] args){

        TempMonitoringServer TempServer = new TempMonitoringServer();

        int port = 50051;

        try {
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
    @Override
    public void getCurrentTemperature(LocationRequest request, StreamObserver<TemperatureResponse> responseObserver)    {
        // Simulate temperature retrieval based on locationID
        String locationID = request.getLocationID();
        // Simulated random temperature (0-100)
        int tempValue = (int) (Math.random() * 100); 
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
        for (int i = 1; i <= 10; i++) { // Simulate 10 temperature readings
            int tempValue = (int) (Math.random() * 100); // Simulated temperature value with some variation
            TemperatureResponse response = TemperatureResponse.newBuilder()
                    .setTempValue(tempValue)
                    .build();

            responseObserver.onNext(response);
            System.out.println("Sent reading " + (i) + " for " + locationID);

            try {
                Thread.sleep(2000); // Simulate delay between readings
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        responseObserver.onCompleted();
    }   

}
