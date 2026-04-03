package com.distsys.WildFireMonitoringSystem.servers;
import grpc.EmergencyResponseService.*;
import grpc.EmergencyResponseService.EmergencyResponseServiceGrpc.EmergencyResponseServiceImplBase;

import java.io.IOException;
import java.util.logging.Logger;

import com.distsys.WildFireMonitoringSystem.naming.JmDNSRegistration;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import com.distsys.WildFireMonitoringSystem.mockDataBase.TemperatureLocationMap;


public class EmergencyResponseServer extends EmergencyResponseServiceImplBase{
    	private static final Logger logger = Logger.getLogger(EmergencyResponseServer.class.getName());
        private static TemperatureLocationMap tempData = new TemperatureLocationMap();
        public static void main(String[] args) {
            EmergencyResponseServer ERPserver = new EmergencyResponseServer();
            int port = 50053;
            try {
                // Start gRPC Server
                Server server = ServerBuilder.forPort(port)
                        .addService(ERPserver)
                        .build()
                        .start();
                logger.info("Emergency Response Server started, listening on " + port);

                // Register the service with JmDNS for discovery
                JmDNSRegistration erp = JmDNSRegistration.getInstance();
                erp.registerService("_grpc._tcp.local.", "WildFireEmergencyResponseService", port, "path=EmergencyResponseService");

                // keep the server running
                server.awaitTermination();
            
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }            
        }
// ------------ gRPC Method Implementations ------------
        // Unary RPC: act on / shut down sprinkler system manually
        @Override
        public void activateSprinklers(ActionRequest request, StreamObserver<ActionResponse> responseObserver) {
        String location = request.getLocation();
        boolean hasActivated = request.getActivate();
        
        tempData.setSprinkler(location, hasActivated);
        System.out.println("received command - location: " + location + ", action: " + (hasActivated ? "activate" : "deactivate"));

        boolean success = true; 
        String msg = "Location [" + location + "] sprinkler has been " + (hasActivated ? "successfully activated" : "successfully deactivated");

        ActionResponse response = ActionResponse.newBuilder()
                .setSuccess(success)
                .setMessage(msg)
                .build();

        // respond to result to client
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    /**
     * BI-DIRECTIONAL STREAMING: monitor device health status in real-time. Clients continuously send health updates, and the server responds with status updates.
     */
    @Override
    public StreamObserver<DeviceHealthRequest> monitorDeviceStatus(StreamObserver<DeviceStatusResponse> responseObserver) {
        
        // anonymous: return a StreamObserver to handle incoming client messages, and use the provided responseObserver to send updates back to the client in real-time. This allows for continuous two-way communication between the server and client.
        return new StreamObserver<DeviceHealthRequest>() {

            @Override
            public void onNext(DeviceHealthRequest request) {
                // 1. receive status update from client
                String id = request.getDeviceID();
                System.out.println("received health update for device: " + id);

                // 2. respond with a status update (for demonstration, we simply echo back a "working" status for any received update)
                DeviceStatusResponse statusUpdate = DeviceStatusResponse.newBuilder()
                        .setDeviceID(id)
                        .setStatus("Working (Normal)")
                        .build();

                // 3. respond to client with the status update
                responseObserver.onNext(statusUpdate);
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error occurred, pausing monitoring: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Client has closed the monitoring stream.");
                responseObserver.onCompleted();
            }
        };
    }
}       
        


