package com.canno.spring.boot.integration.common.util;

import java.util.Locale;

/**
 * Created by Ak_Guili on 2017/9/17.
 */
public class HexUtils {

    private final static String[] hexDigits = {
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"
    };

//    public static String byte2HexStr(byte[] b) {
//        StringBuilder hexStr = new StringBuilder();
//        String hex = "";
//        for (byte aB : b) {
//            hex = Integer.toHexString(aB & 0xFF);
//            if (hex.length() == 1) {
//                hexStr.append("0").append(hex);
//            } else {
//                hexStr.append(hex);
//            }
//
//        }
//        return hexStr.toString().toUpperCase();
//    }

    public static String bytes2HexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(byte2Hex(b));
        }
        return sb.toString();
    }

    /**
     * one  byte convert to two hex String
     *
     * @param b byte
     * @return HexString
     */
    private static String byte2Hex(byte b) {
        int n = b;
        if (n < 0) {
            n += 0x100;
        }

        // 高四位
        int high = n >>> 4;
        // 低四位
        int low = n & 0xf;

        return hexDigits[high] + hexDigits[low];
    }

    public static byte[] hexStr2Bytes(String hexStr) {
        /*对输入值进行规范化整理*/
        hexStr = hexStr.trim().replace(" ", "").toUpperCase(Locale.US);
        //处理值初始化
        int m = 0, n = 0;
        int iLen = hexStr.length() / 2; //计算长度
        byte[] ret = new byte[iLen]; //分配存储空间

        for (int i = 0; i < iLen; i++) {
            m = i * 2 + 1;
            n = m + 1;
            ret[i] = (byte) (Integer.decode("0x" + hexStr.substring(i * 2, m) + hexStr.substring(m, n)) & 0xFF);
        }
        return ret;
    }
}
