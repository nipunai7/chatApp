package com.company.client;

import java.io.*;
import java.util.Scanner;

public class ChatClient {

    public static void main(String[] args) throws IOException {

        System.out.println("Client is connected");
        Client client = new Client();
        client.start();

        Scanner scanner = new Scanner(System.in);  // Create a Scanner object

        while (true){
            String message1 = scanner.nextLine();  // Read user input
            client.sendMessage(message1); // Send user input
        }
    }
}
