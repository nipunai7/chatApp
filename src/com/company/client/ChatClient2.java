package com.company.client;

import java.io.IOException;
import java.util.Scanner;

public class ChatClient2 {

    public static void main(String[] args) throws IOException {

       // System.out.println("Client is connected");
        Client client = new Client();
        client.start();

//        client.sendMessage("Hello");
//        client.sendMessage("Register");
//        client.sendMessage("Nipuna");

        Scanner scanner = new Scanner(System.in);  // Create a Scanner object

        while (true){
            String message1 = scanner.nextLine();  // Read user input
            client.sendMessage(message1); // Send user input
        }




    }
}
