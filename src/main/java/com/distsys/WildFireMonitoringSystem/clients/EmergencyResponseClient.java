package com.distsys.WildFireMonitoringSystem.clients;
import grpc.EmergencyResponseService.*;
import grpc.EmergencyResponseService.EmergencyResponseServiceGrpc;  
import grpc.EmergencyResponseService.EmergencyResponseServiceGrpc.EmergencyResponseServiceBlockingStub;
import grpc.EmergencyResponseService.EmergencyResponseServiceGrpc.EmergencyResponseServiceStub  ;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import java.time.LocalTime;
import java.util.Iterator;


public class EmergencyResponseClient {
    // a non-blocking stub to make an asynchronous call
    private static EmergencyResponseServiceStub asyncStub;

    // a blocking stub to make synchronous calls
    private static EmergencyResponseServiceBlockingStub syncStub;

}
