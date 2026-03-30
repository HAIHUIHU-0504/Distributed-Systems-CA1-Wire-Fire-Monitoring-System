package com.distsys.WildFireMonitoringSystem.naming;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;

public class JmDNSDiscovery {

    private String requiredServiceType;
    private String requiredServiceName;
    private JmDNS jmdns; 
    private String url;

    public JmDNSDiscovery(String inServiceType, String inServiceName) {
        requiredServiceType = inServiceType;
        requiredServiceName = inServiceName;
    }

    public String discoverService(long timeoutMilliseconds) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        url = null; 

        try {
            jmdns = JmDNS.create(InetAddress.getLocalHost());
            System.out.println("Client: InetAddress.getLocalHost():" + InetAddress.getLocalHost());
            
            jmdns.addServiceListener(requiredServiceType, new ServiceListener() {

                @Override
                public void serviceAdded(ServiceEvent event) {
                    jmdns.requestServiceInfo(event.getType(), event.getName());
                    System.out.println("Service added: " + event.getName());
                }

                @Override
                public void serviceRemoved(ServiceEvent event) {
                    System.out.println("Service removed: " + event.getName());
                }

                @Override
                public void serviceResolved(ServiceEvent event) {
                    ServiceInfo info = event.getInfo();
                    int port = info.getPort();
                    String resolvedServiceName = info.getName();

                    System.out.println("####service " + resolvedServiceName + " resolved at: " + port);

                    if (resolvedServiceName.contains(requiredServiceName)) {
                        System.out.println("Discovered service named: " + resolvedServiceName);
                        

                        String path = "index.html"; 
                        String text = info.getNiceTextString();
                        if (text != null && text.contains("=")) {
                            String[] parts = text.split("=");
                            if (parts.length > 1) {
                                path = parts[1];
                            }
                        }

                        String host = "localhost";
                        
                        url = "http://" + host + ":" + port + "/" + path;
                        System.out.println("Final Discovery URL: " + url);
                        
                        latch.countDown(); 
                    }
                }
            });

        } catch (UnknownHostException e) {
            System.out.println("UnknownHost: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }

        latch.await(timeoutMilliseconds, TimeUnit.MILLISECONDS);
        System.out.println("Discover Service returning: " + url);
        return url;
    }
    
    public void close() throws IOException {
        if (jmdns != null) {
            jmdns.close();
            System.out.println("JmDNS closed.");
        }
    }
}