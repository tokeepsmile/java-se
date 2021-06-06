package com.wangwei.demo.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class RequestHandler extends Thread {
    private Socket socket;

    public RequestHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {

            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());

            printWriter.println("hellow world");

            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
