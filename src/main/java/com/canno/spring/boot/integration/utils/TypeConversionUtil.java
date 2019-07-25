package com.canno.spring.boot.integration.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Ak_Guili on 2016/12/8.
 *
 * 只能在测试代码是使用
 */
@SuppressWarnings("all")
public class TypeConversionUtil {
    private static Logger LOG = LoggerFactory.getLogger(TypeConversionUtil.class);
    private static ObjectMapper mapper = new ObjectMapper();
    private static ObjectMapper mapperFomatter = new ObjectMapper();

    static {
        mapperFomatter.enable(SerializationFeature.INDENT_OUTPUT);

        mapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
    }

    public static Object StringToObject(String str, Class c) throws IOException {
        return mapper.readValue(str, c);
    }

    public static <T> T json2Object(String str, Class<T> t) {
        try {
            return mapper.readValue(str, t);
        } catch (IOException e) {
            LOG.error("Type cast error!", e);
            throw new RuntimeException(e);
        }
    }

    public static String object2Json(Object o) {
        try {
            return mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            LOG.error("Type cast error!", e);
            throw new RuntimeException(e);
        }
    }

    public static <T> T json2Object(String content, TypeReference valueTypeRef) {
        try {
            return mapper.readValue(content, valueTypeRef);
        } catch (IOException e) {
            LOG.error("Type cast error!", e);
            throw new RuntimeException(e);
        }
    }

    public static String object2JsonFormat(Object o) {
        try {
            return mapperFomatter.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            LOG.error("Type cast error!", e);
            throw new RuntimeException(e);
        }
    }


    public static String jsonFormat(String data) {
        return object2JsonFormat(json2Object(data, HashMap.class));
    }
}
