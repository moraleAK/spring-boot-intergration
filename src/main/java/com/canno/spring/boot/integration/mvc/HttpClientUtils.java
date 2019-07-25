package com.canno.spring.boot.integration.mvc;

import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/**
 * Created by Ak_Guili on 2017/6/21.
 */
public class HttpClientUtils {
    private static org.slf4j.Logger LOG = LoggerFactory.getLogger(HttpClientUtils.class);

    public static String sendHttpRequest(String url, Object data) {
        HttpEntity<Object> entity = new HttpEntity<Object>(data);
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<byte[]> ret = restTemplate.exchange(url, HttpMethod.POST, entity, byte[].class);
            if (ret.getBody() == null) {
                return null;
            }
            LOG.info("res:{}",  new String(ret.getBody(), "utf-8"));
            return new String(ret.getBody(), "utf-8");

        } catch (UnsupportedEncodingException | RestClientException e) {
            LOG.error(e.getMessage(), e);
            LOG.info("error");
            return null;
        }
    }


    public static String sendHttpRequestByXMl(String url, String xml) {
        HttpEntity<Object> entity = new HttpEntity<Object>(xml);
        RestTemplate restTemplate = new RestTemplate();
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName("utf-8"));
        restTemplate.getMessageConverters().set(1, stringHttpMessageConverter);
        try {
            long b = System.currentTimeMillis();
            ResponseEntity<byte[]> ret = restTemplate.exchange(url, HttpMethod.POST, entity, byte[].class);
            LOG.info("res:{}", new String(ret.getBody(), "utf-8"));
            return new String(ret.getBody(), "utf-8");
        } catch (RestClientException | UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String sendHttpRequestByXml(String url, Object data) {

        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/xml; charset=UTF-8");
        headers.setContentType(type);
        HttpEntity<Object> entity = new HttpEntity<Object>(data,headers);
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<byte[]> ret = restTemplate.exchange(url, HttpMethod.POST, entity, byte[].class);
            if (ret.getBody() == null) {
                return null;
            }
            LOG.info("res:{}", new String(ret.getBody(), "utf-8"));
            return new String(ret.getBody(), "utf-8");

        } catch (UnsupportedEncodingException | RestClientException e) {
            LOG.error(e.getMessage(), e);
            return null;
        }
    }


    public static SSLContext createIgnoreVerifySSL() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sc = SSLContext.getInstance("SSLv3");

        // 实现一个X509TrustManager接口，用于绕过验证，不用修改里面的方法
        X509TrustManager trustManager = new X509TrustManager() {
            @Override
            public void checkClientTrusted(
                    java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
                    String paramString) throws CertificateException {

            }

            @Override
            public void checkServerTrusted(
                    java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
                    String paramString) throws CertificateException {
            }

            @Override
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };

        sc.init(null, new TrustManager[]{trustManager}, null);
        return sc;
    }

    public static void main(String[] args) {
        HttpClientUtils.sendHttpRequest("https://www.baidu.com", "hello");
    }
}
