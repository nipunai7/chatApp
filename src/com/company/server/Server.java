package com.company.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {



    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Server running...");
        ServerSocket serversocket = new ServerSocket(6000);
        System.out.println("Server socket created...");

        while (true){

            Socket client = serversocket.accept();
            System.out.println("Server accepted a Client");
            ClientHandler clientHandler = new ClientHandler(client);
            Thread thread = new Thread(clientHandler);
            thread.start();
        }

    }
}
