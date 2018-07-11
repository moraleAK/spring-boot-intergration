package com.canno.spring.boot.integration.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Canno
 * @since 2018/6/28 17:06
 */
public class SocketServer {
    public void init() throws IOException {
        ServerSocket serverSocket = new ServerSocket(9001);
        Socket socket = serverSocket.accept();
        InputStream in = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int count;
        while (true) {
            System.out.println("there has new request!");
            while ((count = in.read(bytes)) != -1) {
                System.out.println(new String(bytes));
            }
            socket.shutdownInput();
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("Welcome to Fire Sky ！");
            pw.flush();
        }
    }

    public static void main(String[] args) throws IOException {
        new SocketServer().init();
    }
}
