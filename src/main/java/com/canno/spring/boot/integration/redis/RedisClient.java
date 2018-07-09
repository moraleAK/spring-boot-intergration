package com.canno.spring.boot.integration.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * User: Rolandz
 * Date: 9/6/16
 * Time: 8:21 PM
 */
@Service
public class RedisClient {
    private final RedisTemplate<Object,Object> redisTemplate;

    @Autowired
    public RedisClient(RedisTemplate<Object, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     *
     * 存储或更新cache
     *
     * @param key 键
     *
     * @param value 值
     */
    public void addOrUpdate(String key,Object value,Integer interval,TimeUnit unit) {
        redisTemplate.opsForValue().set(key, value, interval, unit);
    }

    /**
     * 过期时间从调用该 api 起，顺延
     * @param key key
     * @param value value
     */
    public void addOrUpdate(String key, Object value) {
        Long expire = redisTemplate.getExpire(key, TimeUnit.SECONDS);
        if (expire > 0) {
            redisTemplate.opsForValue().set(key, value, expire, TimeUnit.SECONDS);
        }
        else {
            redisTemplate.opsForValue().set(key, value);
        }
    }

    /**
     *
     * 查询用户cache
     *
     * @param key 键
     * @return 值
     */
    public Object load(String key) {
        return redisTemplate.boundValueOps(key).get();
    }

    public void delete(String key){
        redisTemplate.delete(key);
    }

}
