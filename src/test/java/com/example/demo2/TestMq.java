package com.example.demo2;

import com.example.demo2.mq.HelloSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author yangshaojun
 * @ClassName TestMq
 * @Description
 * @create 2019-04-10 下午 16:01
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMq {

    @Autowired
    private HelloSender helloSender;

    @Test
    public void hello() throws Exception {
        helloSender.send();
    }
}
