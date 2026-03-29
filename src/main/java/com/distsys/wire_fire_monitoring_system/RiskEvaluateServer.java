package com.distsys.wire_fire_monitoring_system;
import grpc.RiskEvaluateService.*;
import grpc.RiskEvaluateService.RiskEvaluateServiceGrpc.RiskEvaluateServiceImplBase;

import java.io.IOException;
import java.util.Random;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import io.grpc.stub.StreamObserver;
public class RiskEvaluateServer extends RiskEvaluateServiceImplBase {

        private static final Logger logger = Logger.getLogger(RiskEvaluateServer.class.getName());
    
        public static void main(String[] args){
    
            RiskEvaluateServer RiskServer = new RiskEvaluateServer();
    
            int port = 50052;
    
            try {
                Server server = ServerBuilder.forPort(port)
                .addService(RiskServer)
                .build()
                .start();
                logger.info("Server started, listening on " + port);
                System.out.println("Risk evaluation Server started, listening on " + port);		   
                server.awaitTermination();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        @Override
        public void evaluateRisk(EnvironmentalData request, StreamObserver<RiskAssessment> responseObserver)    {
            // Simulate risk evaluation based on temperature and locationID
            System.out.println("Received risk evaluation request for location: " + request.getLocationID() + " with temperature: " + request.getTempValue());
            // Simulated risk level (0，1，2，3)
            int temp = request.getTempValue(); // Initialize risk level
            int riskLevel = 0; // Initialize risk level
            String msg = ""; // Optional message for risk assessment
            if (temp > 80) {
                riskLevel = 3; // High risk
                msg="High risk of fire detected! Immediate action required.";
            } else if (temp > 60) {
                riskLevel = 2; // Medium risk
                msg="Medium risk of fire detected. Monitor closely.";
            } else if (temp > 40) {
                riskLevel = 1; // Low risk
                msg="Low risk of fire detected. Keep monitoring.";
            } else {
                riskLevel = 0; // No risk
                msg="No significant risk of fire detected.";
            }
            // Builder for response
            RiskAssessment response = RiskAssessment.newBuilder()
                    .setRiskLevelValue(riskLevel)
                    .setMessage(msg)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }   

}
