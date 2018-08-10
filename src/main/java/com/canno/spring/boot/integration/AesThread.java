package com.canno.spring.boot.integration;

import com.canno.spring.boot.integration.common.security.encrypt.AesUtils;

public class AesThread extends Thread{
    @Override
    public void run() {
        while (true) {
            System.out.println(AesUtils.encode("zhanjinkai", "1234567891234567".getBytes()));
            try {
                Thread.sleep(1L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 200; i++){
            new AesThread().start();
        }
    }
}
