package com.distsys.WildFireMonitoringSystem;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Iterator;

import com.distsys.WildFireMonitoringSystem.naming.JmDNSDiscovery;

import grpc.TempMonitoringService.*;
import grpc.TempMonitoringService.TempMonitoringServiceGrpc.*;
import grpc.RiskEvaluateService.*;
import grpc.RiskEvaluateService.RiskEvaluateServiceGrpc.*;
import grpc.EmergencyResponseService.*;
import grpc.EmergencyResponseService.EmergencyResponseServiceGrpc.*;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class WildFireMainGUI extends JFrame {
    private JTextArea logArea;
    private JTextField zoneInput, tempInput;
    private JLabel statusLabel;

    // create new gRPC Stubs
    private TempMonitoringServiceBlockingStub tempStub;
    private RiskEvaluateServiceBlockingStub riskStub;
    private EmergencyResponseServiceBlockingStub emergencySyncStub;
    private EmergencyResponseServiceStub emergencyAsyncStub;

    public WildFireMainGUI() {
        //set gui name
        setTitle("WildFire Monitoring System - SDG project");
        //set gui size
        setSize(800, 600);
        //set gui close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        setLayout(new BorderLayout());

        // --- 1. top: services didcovery ---
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnDiscover = new JButton("1. Discover All Services");
        statusLabel = new JLabel("Status: Disconnected");
        topPanel.add(btnDiscover);
        topPanel.add(statusLabel);
        add(topPanel, BorderLayout.NORTH);

        // --- 2. control panel  ---
        JPanel controlPanel = new JPanel(new GridLayout(4, 1, 5, 5));
        controlPanel.setBorder(BorderFactory.createTitledBorder("Service Controls"));

        // temp service (Server Streaming)
        JPanel tempPanel = new JPanel();
        zoneInput = new JTextField("Zone A", 8);
        JButton btnMonitor = new JButton("Monitor Temp History");
        tempPanel.add(new JLabel("Zone ID:"));
        tempPanel.add(zoneInput);
        tempPanel.add(btnMonitor);
        controlPanel.add(tempPanel);

        // risk evaluation (Unary)
        JPanel riskPanel = new JPanel();
        tempInput = new JTextField("25", 5);
        JButton btnEval = new JButton("Evaluate Risk");
        riskPanel.add(new JLabel("Manual Temp:"));
        riskPanel.add(tempInput);
        riskPanel.add(btnEval);
        controlPanel.add(riskPanel);

        // emergency response (Unary & Bi-directional)
        JPanel emergencyPanel = new JPanel();
        JButton btnSprinkler = new JButton("Toggle Sprinkler");
        JButton btnHealth = new JButton("Start Device Health Bi-di");
        emergencyPanel.add(btnSprinkler);
        emergencyPanel.add(btnHealth);
        controlPanel.add(emergencyPanel);

        add(controlPanel, BorderLayout.WEST);

        // --- 3. right: log output ---
        logArea = new JTextArea();
        logArea.setBackground(Color.BLACK);
        logArea.setForeground(Color.GREEN);
        logArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        add(new JScrollPane(logArea), BorderLayout.CENTER);

        // A. service discovery
        btnDiscover.addActionListener(e -> discoverServices());

        // B. temp monitoring (Server Streaming)
        btnMonitor.addActionListener(e -> {
            if (tempStub == null) { appendLog("Error: Discover service first!"); return; }
            new Thread(() -> {
                appendLog("--- Starting Temp Monitor for " + zoneInput.getText() + " ---");
                LocationRequest req = LocationRequest.newBuilder().setLocationID(zoneInput.getText()).build();
                Iterator<TemperatureResponse> responses = tempStub.monitorTemperature(req);
                while (responses.hasNext()) {
                    appendLog("Stream Recv: " + responses.next().getTempValue() + "°C");
                }
                appendLog("--- Stream Completed ---");
            }).start();
        });

        // C. risk evaluation (Unary)
        btnEval.addActionListener(e -> {
            if (riskStub == null) { appendLog("Error: Discover service first!"); return; }
            int t = Integer.parseInt(tempInput.getText());
            EnvironmentalData req = EnvironmentalData.newBuilder().setLocationID(zoneInput.getText()).setTempValue(t).build();
            RiskAssessment res = riskStub.evaluateRisk(req);
            appendLog("Risk Result: " + res.getMessage() + " (Level " + res.getRiskLevelValue() + ")");
        });

        // D. devices status (Bi-directional Streaming)
        btnHealth.addActionListener(e -> {
            if (emergencyAsyncStub == null) { appendLog("Error: Discover service first!"); return; }
            startHealthStreaming();
        });
    }

    private void discoverServices() {
        new Thread(() -> {
            try {
                appendLog("Starting JmDNS Discovery...");
                // discovery and connect temp service (port 50051)
                connectTempService();
                // discovery and connect risk service (port 50052)
                connectRiskService();
                // discovery and connect emergency service (port 50053)
                connectEmergencyService();
                
                statusLabel.setText("Status: All Services Connected");
                statusLabel.setForeground(new Color(0, 150, 0));
            } catch (Exception ex) {
                appendLog("Discovery Error: " + ex.getMessage());
            }
        }).start();
    }

    private void connectTempService() throws Exception {
        JmDNSDiscovery disc = new JmDNSDiscovery("_grpc._tcp.local.", "WildFireTempService");
        String url = disc.discoverService(3000);
        if (url != null) {
            ManagedChannel chan = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
            tempStub = TempMonitoringServiceGrpc.newBlockingStub(chan);
            appendLog("Connected to TempService.");
        }
    }

    private void connectRiskService() throws Exception {
        ManagedChannel chan = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
        riskStub = RiskEvaluateServiceGrpc.newBlockingStub(chan);
        appendLog("Connected to RiskService.");
    }

    private void connectEmergencyService() throws Exception {
        ManagedChannel chan = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();
        emergencySyncStub = EmergencyResponseServiceGrpc.newBlockingStub(chan);
        emergencyAsyncStub = EmergencyResponseServiceGrpc.newStub(chan);
        appendLog("Connected to EmergencyService.");
    }

    private void startHealthStreaming() {
        StreamObserver<DeviceStatusResponse> responseObserver = new StreamObserver<DeviceStatusResponse>() {
            @Override public void onNext(DeviceStatusResponse res) {
                appendLog("Health Update: Device " + res.getDeviceID() + " is " + res.getStatus());
            }
            @Override public void onError(Throwable t) { appendLog("Bi-di Error: " + t.getMessage()); }
            @Override public void onCompleted() { appendLog("Bi-di Stream Closed."); }
        };

        StreamObserver<DeviceHealthRequest> requestObserver = emergencyAsyncStub.monitorDeviceStatus(responseObserver);
        requestObserver.onNext(DeviceHealthRequest.newBuilder().setDeviceID("Sensor_A1").build());
        requestObserver.onNext(DeviceHealthRequest.newBuilder().setDeviceID("Sprinkler_A1").build());
        requestObserver.onCompleted();
    }

    private void appendLog(String msg) {
        SwingUtilities.invokeLater(() -> logArea.append(msg + "\n"));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WildFireMainGUI().setVisible(true));
    }
}