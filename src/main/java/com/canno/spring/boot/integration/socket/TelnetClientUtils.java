package com.canno.spring.boot.integration.socket;

import org.apache.commons.net.telnet.TelnetClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetAddress;

/**
 * network connect test
 * telnet port is opened and ping host is opened
 *
 * @author Canno
 * @since 2018/7/16 16:21
 */
public class TelnetClientUtils {
    private static Logger logger = LoggerFactory.getLogger(TelnetClientUtils.class);

    public static boolean isOpened(String host, int port) {
        TelnetClient telnet = new TelnetClient();

        try {
            telnet.connect(host, port);
        } catch (IOException e) {
            logger.error("{}:{} is connected refused!");
            logger.error(e.getMessage(), e);
            return true;
        }

        try {
            telnet.disconnect();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    public static boolean isPinged(String host){
        try {
            return InetAddress.getByName(host).isReachable(3000);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(TelnetClientUtils.isPinged("baidu.com"));
    }
}
