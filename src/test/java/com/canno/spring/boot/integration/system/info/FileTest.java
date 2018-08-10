package com.canno.spring.boot.integration.system.info;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileTest {
    private static String path = "/Users/zhanjinkai/Documents/text/";
    @Test
    public void test() throws IOException {
        String fileName = path + "text2.txt";
        File file = new File(fileName);
        FileOutputStream os = new FileOutputStream(file);
        long t1 = System.currentTimeMillis();
        String ss = "zhanjinkai1233455667788990000099923849238492834293492382834823848283427347286" +
                "27348234826343678424688888888dsadasdasdasdasdwewesdsadsadweweqsdaw";
        String sss = ss + ss + ss + ss + ss + ss + ss + ss + ss;
        String ssss = sss + sss + sss + sss + sss + sss + sss;
        for(int i= 0; i< 200000; i ++) {
            os.write(ssss.getBytes());
        }
        os.close();
        System.out.println(System.currentTimeMillis() - t1);
    }
}
