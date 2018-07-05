package com.canno.blog;

import com.canno.blog.mq.active.Producer;
import com.canno.blog.mq.active.Publisher;
import com.canno.blog.redis.RedisClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogShareApplicationTests {
    @Resource
    Producer producer;
    @Resource
    Publisher publisher;
    @Autowired
    RedisClient redisClient;

    @Test
    public void contextLoads() {
        for(int i = 0; i < 10; i ++){
//            producer.sendMessage("canno.test", "第" + i + "条消息！");
            publisher.publish("canno.topic","第" + i + "条消息！");
        }
    }

    @Test
    public void redisTest(){
        redisClient.addOrUpdate("test","666");
        System.out.println(redisClient.load("test"));
    }
}
