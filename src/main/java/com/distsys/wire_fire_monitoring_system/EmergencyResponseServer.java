package com.distsys.wire_fire_monitoring_system;
import grpc.EmergencyResponseService.*;
import grpc.EmergencyResponseService.EmergencyResponseServiceGrpc.EmergencyResponseServiceImplBase;

import java.io.IOException;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import io.grpc.stub.StreamObserver;


public class EmergencyResponseServer extends EmergencyResponseServiceImplBase{
    	private static final Logger logger = Logger.getLogger(EmergencyResponseServer.class.getName());
        public static void main(String[] args) {
            int port = 50051;
            try {
                Server server = ServerBuilder.forPort(port)
                        .addService(new EmergencyResponseServer())
                        .build()
                        .start();
                logger.info("Emergency Response Server started, listening on " + port);
                server.awaitTermination();
            } catch (IOException | InterruptedException e) {
                logger.severe("Server error: " + e.getMessage());
            }            
        }
        // @Override
        // public void activateSprinklers(ActivateSprinklersRequest request, StreamObserver<ActivateSprinklersResponse> responseObserver) {
        //     // Simulate sprinkler activation logic
        //     logger.info("Received ActivateSprinklersRequest for location: " + request.getLocation());
        //     boolean success = true; // Simulate successful activation
        //     String message = "Sprinklers activated at " + request.getLocation();
        //     ActivateSprinklersResponse response = ActivateSprinklersResponse.newBuilder()
        //             .setSuccess(success)
        //             .setMessage(message)
        //             .build();
        //     responseObserver.onNext(response);
        //     responseObserver.onCompleted();
        // }
        // @Override
        // public void monitorDeviceStatus(MonitorDeviceStatusRequest request, StreamObserver<MonitorDeviceStatusResponse> responseObserver) {
        //     // Simulate device status monitoring logic
        //     logger.info("Received MonitorDeviceStatusRequest for device: " + request.getDeviceId());
        //     String status = "OK"; // Simulate device status
        //     MonitorDeviceStatusResponse response = MonitorDeviceStatusResponse.newBuilder()
        //             .setStatus(status)
        //             .build();
        //     responseObserver.onNext(response);
        //     responseObserver.onCompleted();
        }       
        


