package com.company.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable{

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

            String name="";
            String inputData;

            while ((inputData = bufferedReader.readLine()) != null){

                System.out.println("Data From Client: "+inputData);

                switch (inputData) {

                    default -> {
                        String newMsg = scanner.nextLine();
                        outputStream.writeBytes(newMsg+"\n");
                        }
                }

                if(inputData.equals("exit")){
                    break;
                }

            }

            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
