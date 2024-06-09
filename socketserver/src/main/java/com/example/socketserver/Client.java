package com.example.socketserver;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        Socket socket = null;

        try {
            socket = new Socket("localhost", 12345);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String message = "Hello from client!";
            out.println(message);

            String response = in.readLine();
            System.out.println("Received from server: " + response);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
