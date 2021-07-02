package com.company.client;

import com.company.observerPattern.Category;
import com.company.observerPattern.Observer;
import com.company.observerPattern.Reader;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {


    private DataOutputStream dataOutputStream;
    private BufferedReader bufferedReader;

    public void start() throws IOException {


        Category valorant = new Category("Valorant");
        Category cod4 = new Category("CoD4");

            System.out.println("Client is running...");
            Socket socket = new Socket("localhost", 6000);
            this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
            InputStream inputStream = socket.getInputStream();
            this.bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Please Enter your Name: ");
        String name = scanner.nextLine();

        Observer reader1 = new Reader(name); // Creating the Observer
        System.out.println("Welcome "+name);

        System.out.println("Please select a Channel to Subscribe: \n 1.Valorant \n 2.CoD4");

        String choice = scanner.nextLine();
        if (choice.equals("Valorant") || choice.equals("1")) {
            valorant.subscribe(reader1);
            System.out.println("You have successfully Subscribed to: Valorant");
        }
        if (choice.equals("CoD4") || choice.equals("2")) {
            cod4.subscribe(reader1);
            System.out.println("You have successfully Subscribed to: CoD4");
        }
    }

    public void sendMessage(String message) throws IOException{
       // System.out.println("Client Message: "+message);
        this.dataOutputStream.writeBytes(message+"\n");
        System.out.println("Data from Server: "+this.bufferedReader.readLine());
    }
}