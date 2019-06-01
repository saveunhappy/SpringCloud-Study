package com.mypack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulGatewayApp_9527 {
    public static void main(String[] args) {
        SpringApplication.run(ZuulGatewayApp_9527.class,args);
    }
}
