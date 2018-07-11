package com.canno.spring.boot.integration.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @author Canno
 * @since 2018/6/28 17:27
 */
public class SocketClient {
    public void send() throws IOException, InterruptedException {
        while (true) {
            Socket socket = new Socket("localhost", 9002);
            socket.getOutputStream().write("Jame.Kin".getBytes());
            socket.shutdownOutput();
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            while ((inputStream.read(bytes)) != -1){
                System.out.println(new String(bytes));
            }
            socket.close();
            Thread.sleep(3000L);
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        new SocketClient().send();
    }
}
