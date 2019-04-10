package com.example.demo2.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yangshaojun
 * @ClassName RabbitConfig
 * @Description
 * @create 2019-04-10 下午 16:00
 * @Version 1.0
 **/

//@Configuration
public class RabbitConfig {

    @Bean
    public Queue Queue() {
        return new Queue("hello");
    }

}
