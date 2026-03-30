package com.distsys.WildFireMonitoringSystem.clients;
import grpc.RiskEvaluateService.*;
import grpc.RiskEvaluateService.RiskEvaluateServiceGrpc.RiskEvaluateServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class RiskEvaluationClient {
    // a blocking stub to make synchronous calls
    private static RiskEvaluateServiceBlockingStub syncStub;
    public static void main(String[] args) {
        ManagedChannel riskChannel = ManagedChannelBuilder
                    .forAddress("localhost", 50052)
                    .usePlaintext()
                    .build();
        // Create a blocking stub for unary and server streaming calls
        syncStub = RiskEvaluateServiceGrpc.newBlockingStub(riskChannel);

        // Evaluate risk for Zone A with a temperature of 21°C
        evaluateRisk("Zone A", 21);
    }
   
         private static void evaluateRisk(String location, int temp) {
        System.out.println("Evaluating risk for " + location + " with temperature: " + temp + "°C...");
        // Create a request message
        EnvironmentalData request = EnvironmentalData.newBuilder()
                .setLocationID(location)
                .setTempValue(temp)
                .build();
        // Make a unary call to the server
        RiskAssessment response = syncStub.evaluateRisk(request);
        // Print the response
        System.out.println("Risk level in " + location + ": " + response.getRiskLevel() + " - " + response.getMessage());
    }
}
 