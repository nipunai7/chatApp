package com.company.server;

import com.company.observerPattern.Category;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable{

    Category valorant = new Category("Valorant");
    Category cod4 = new Category("CoD4");

    private Socket client;

    public ClientHandler(Socket socket) {

        this.client = socket;

    }

    @Override
    public void run() {

        try {
            InputStream inputStream = client.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
            Scanner scanner = new Scanner(System.in);


            while (true){

                System.out.println("What Category you want to update? \n1. Valorant \n2. CoD4");
                String newMsg = scanner.nextLine();
                if (newMsg == "1"){
                    valorant.upload("Test 1");
                }
                if (newMsg == "2"){
                    cod4.upload("Test 2");
                }


            }

        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
