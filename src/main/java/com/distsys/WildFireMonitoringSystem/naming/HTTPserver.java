package com.distsys.WildFireMonitoringSystem.naming;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.time.LocalDate;
import java.time.LocalTime;

public class HTTPserver {
    
    
     public static void main(String[] args) throws Exception {
    	
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/index.html", new MyHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
        // The server registers itself so that clients can discover it
        JmDNSRegistration tmsr = JmDNSRegistration.getInstance();
        tmsr.registerService("_http._tcp.local.", "WildFireTempService", 8000, "path=index.html");
        
    }

    static class MyHandler implements HttpHandler {
    	
        public void handle(HttpExchange t) throws IOException {
           System.out.println(t.getRequestBody().toString());
           String response = "This is the response from Server1 at " + LocalTime.now();
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
            
        }
    }
}