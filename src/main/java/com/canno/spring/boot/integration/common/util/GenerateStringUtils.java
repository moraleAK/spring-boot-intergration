package com.canno.spring.boot.integration.common.util;

import java.util.Random;

/**
 * Created by Ak_Guili on 2017/9/17.
 */
public class GenerateStringUtils {
    private static final String STR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final String HEX_STR = "abcdef0123456789";
    private static final String FLOW_NM = "0123456789";

    public static String getRandomString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            sb.append(STR.charAt(number));
        }
        return sb.toString();
    }

    public static String getFlowNm(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(10);
            sb.append(FLOW_NM.charAt(number));
        }
        return sb.toString();
    }

    public static String getHEX32(){
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            int number = random.nextInt(10);
            sb.append(FLOW_NM.charAt(number));
        }
        return sb.toString();
    }
}
