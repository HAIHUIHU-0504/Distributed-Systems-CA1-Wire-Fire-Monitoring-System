package com.distsys.wire_fire_monitoring_system;
import grpc.HumidityMonitoringService.*;
import grpc.HumidityMonitoringService.HumidityMonitoringServiceGrpc.HumidityMonitoringServiceImplBase;

import java.io.IOException;
import java.util.Random;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import io.grpc.stub.StreamObserver;
public class HumidityResponseServer extends HumidityMonitoringServiceImplBase {

    private static final Logger logger = Logger.getLogger(HumidityResponseServer.class.getName());

    public static void main(String[] args){

        HumidityResponseServer HumidityServer = new HumidityResponseServer();

        int port = 50052;

        try {
            Server server = ServerBuilder.forPort(port)
            .addService(HumidityServer)
            .build()
            .start();
            logger.info("Server started, listening on " + port);
            System.out.println("Humidity monitoring Server started, listening on " + port);		   
            server.awaitTermination();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void getCurrentHumidity(LocationRequest request, StreamObserver<HumidityResponse> responseObserver)       
    {
        String locationID = request.getLocationID();
        double humidityValue = Math.random() * 100; // Simulated random humidity value (0-100)
        HumidityResponse response = HumidityResponse.newBuilder()
                .setHumidityValue(humidityValue)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    @Override
    public void monitorHumidity(LocationRequest request, StreamObserver<HumidityResponse> responseObserver)
    {
        String locationID = request.getLocationID();
        for (int i = 1; i <= 10; i++) { // Simulate 10 humidity readings
            int humidityValue = (int) (Math.random() * 100); // Simulated humidity value with some variation
            int timeStamp = (int) (System.currentTimeMillis() / 1000); // Current timestamp in seconds
            HumidityResponse response = HumidityResponse.newBuilder()
                    .setHumidityValue(humidityValue)
                    .setTimeStamp(timeStamp)
                    .build();

            responseObserver.onNext(response);
            try {
                Thread.sleep(1000); // Simulate delay between readings
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        responseObserver.onCompleted();
    }   



}
