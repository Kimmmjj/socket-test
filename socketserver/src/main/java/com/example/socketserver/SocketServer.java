package com.example.socketserver;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.net.*;

@SpringBootApplication
public class SocketServer implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SocketServer.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server started and listening on port 12345");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connection from " + clientSocket.getInetAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String clientMessage = in.readLine();
            System.out.println("Received from client: " + clientMessage);

            String response = "Hello from server!";
            out.println(response);

            clientSocket.close();
        }
    }
}
