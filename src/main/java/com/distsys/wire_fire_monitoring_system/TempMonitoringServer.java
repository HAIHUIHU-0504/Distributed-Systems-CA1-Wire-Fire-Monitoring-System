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
        double tempValue = Math.random() * 50; // Simulated temperature value
        int timeStamp = (int) (System.currentTimeMillis() / 1000); // Current timestamp in seconds

        TemperatureResponse response = TemperatureResponse.newBuilder()
                .setTempValue(tempValue)
                .setTimeStamp(timeStamp)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    @Override
    public void monitorTemperature(LocationRequest request, StreamObserver<TemperatureResponse> responseObserver)    
    {
        String locationID = request.getLocationID();
        for (int i = 0; i < 5; i++) { // Simulate 5 temperature readings
            double tempValue = 25.0 + Math.random() * 5; // Simulated temperature value with some variation
            int timeStamp = (int) (System.currentTimeMillis() / 1000); // Current timestamp in seconds

            TemperatureResponse response = TemperatureResponse.newBuilder()
                    .setTempValue(tempValue)
                    .setTimeStamp(timeStamp)
                    .build();

            responseObserver.onNext(response);

            try {
                Thread.sleep(2000); // Simulate delay between readings
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        responseObserver.onCompleted();
    }   

}
