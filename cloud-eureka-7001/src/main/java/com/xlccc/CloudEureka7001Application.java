package com.xlccc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //启动Eureka服务器
public class CloudEureka7001Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudEureka7001Application.class, args);
    }

}
