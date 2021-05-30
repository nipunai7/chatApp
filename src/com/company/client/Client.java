package com.company.client;

import java.io.*;
import java.net.Socket;

public class Client {


    private DataOutputStream dataOutputStream;
    private BufferedReader bufferedReader;

    public void start() throws IOException {

            System.out.println("Client is running...");
            Socket socket = new Socket("localhost", 6000);
            this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
            InputStream inputStream = socket.getInputStream();
            this.bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//
//        if ((this.bufferedReader.readLine())!= null){
//            System.out.println("Data from Server: "+this.bufferedReader.readLine());
//        }
    }

    public void sendMessage(String message) throws IOException{
       // System.out.println("Client Message: "+message);
        this.dataOutputStream.writeBytes(message+"\n");
        System.out.println("Data from Server: "+this.bufferedReader.readLine());
    }
}