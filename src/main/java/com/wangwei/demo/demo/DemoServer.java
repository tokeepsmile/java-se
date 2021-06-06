package com.wangwei.demo.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DemoServer extends Thread {
    private ServerSocket serverSocket;

    public int getPort() {
        return serverSocket.getLocalPort();
    }


    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(0);
            ExecutorService executorService = Executors.newFixedThreadPool(8);
            while (true) {
                Socket socket = serverSocket.accept();
                RequestHandler requestHandler = new RequestHandler(socket);
//            requestHandler.start();
                executorService.execute(requestHandler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {

                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        DemoServer server = new DemoServer();
        server.start();

        Socket client = new Socket(InetAddress.getLocalHost(), server.getPort());

        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));

        reader.lines().forEach(s -> System.out.println(s));


    }
}
