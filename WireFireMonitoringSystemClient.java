/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.distsys.wire_fire_monitoring_system;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.logging.Level;

import grpc.TempMonitoringService.LocationRequest;
import grpc.TempMonitoringService.TempMonitoringServiceGrpc;
import grpc.TempMonitoringService.TempMonitoringServiceGrpc.TempMonitoringServiceBlockingStub;
import grpc.TempMonitoringService.TemperatureResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

/**
 *
 * @author haihui hu
 * @student ID:x24312797
 */
public class WireFireMonitoringSystemClient {
    private static final Logger logger = Logger.getLogger(WireFireMonitoringSystemClient.class.getName());

    public static void main(String[] args) throws Exception {
        String host = "localhost";
		int port = 50051;

        ManagedChannel channel = ManagedChannelBuilder
                        .forAddress(host, port)
                        .usePlaintext().build();

        // create a blocking stub
        TempMonitoringServiceBlockingStub TempMoStub = 
                TempMonitoringServiceGrpc.newBlockingStub(channel);

	    try {
			String location = "Area A"; // this is the value that will be sent on the request to the server

			// Create a location request and get the current temperature response from the server
			LocationRequest request = LocationRequest.newBuilder().setLocationID(location).build();
			TemperatureResponse response = TempMoStub.getCurrentTemperature(request);
			logger.info("Location : " + location + ", Current Temperature : " + response.getTempValue()+ "°C, Timestamp : " + response.getTimeStamp());
                 
			Iterator<TemperatureResponse> responses = TempMoStub.monitorTemperature(request);
			while (responses.hasNext()) {
				TemperatureResponse serverResponse = responses.next();
				System.out.println("Received: " + serverResponse.getTempValue() + " at " + serverResponse.getTimeStamp());
			}
		
			} catch (StatusRuntimeException e) {
		    logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
		    
		    return;		
		    
	    } finally {
	    	//shutdown channel
	    	channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	    }
    }
}
