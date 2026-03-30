package com.distsys.WildFireMonitoringSystem.clients;

import grpc.TempMonitoringService.*;
import grpc.TempMonitoringService.TempMonitoringServiceGrpc.TempMonitoringServiceBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.util.Iterator;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Level;
import java.util.logging.Logger;


import com.distsys.WildFireMonitoringSystem.naming.*;

public class TempMonitoringClient {
    // a blocking stub to make synchronous calls
    private static TempMonitoringServiceBlockingStub syncTMStub;

    public static void main(String[] args) {
         // discover the service of type ""_http._tcp.local." with name "example""
        JmDNSDiscovery tmsDiscovry = new JmDNSDiscovery("_http._tcp.local.", "WildFireTempService");
       
        try {
            String url = tmsDiscovry.discoverService(10000);
            
            if (url == null) {
                System.out.println("Could not discover service. Exiting...");
                tmsDiscovry.close();
                return;
            }

            System.out.println("Discovered service at url:  " + url);

            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.statusCode());
            }
            
            System.out.println("Output from HTTP Server .... \n" + response.body());


            URL parsedUrl = new URL(url);
            String host = parsedUrl.getHost();
            int port = 50051;

            System.out.println("\nConnecting to gRPC Service at " + host + ":" + port + "...");
            
            ManagedChannel tempChannel = ManagedChannelBuilder
                    .forAddress(host, port)
                    .usePlaintext()
                    .build();

            syncTMStub = TempMonitoringServiceGrpc.newBlockingStub(tempChannel);

            getCurrentTemperature("Zone A");
            getTemperatureHistory("Zone A");

            tempChannel.shutdown();
            tmsDiscovry.close();

        } catch (Exception e) { 
            e.printStackTrace();
            if (tmsDiscovry != null) {
        try {
            tmsDiscovry.close();
        } catch (IOException ioe) {
            System.err.println("Error while closing JmDNS: " + ioe.getMessage());
        }
    }
        }
    }


    // Get current temperature for Zone A
    private static void getCurrentTemperature(String location) {
        System.out.println("Getting " + location + " current temperature ...");
        // Create a request message
        LocationRequest request = LocationRequest.newBuilder()
                .setLocationID(location)
                .build();
        // Make a unary call to the server
        TemperatureResponse response = syncTMStub.getCurrentTemperature(request);
        // Print the response
        System.out.println("Current temperature in " + location + ": " + response.getTempValue() + "°C");
    }

    // Get temperature history for Zone A
    private static void getTemperatureHistory(String location) {
        System.out.println("Getting " + location + " temperature history ...");
        // Create a request message
        LocationRequest request = LocationRequest.newBuilder()
                .setLocationID(location)
                .build();
        // Make a server streaming call to the server
        Iterator<TemperatureResponse> responses = syncTMStub.monitorTemperature(request);
        // Print the responses
        while (responses.hasNext()) {
            TemperatureResponse response = responses.next();
            System.out.println("Temperature in " + location + ": " + response.getTempValue() + "°C" );
        }
    }


}
 