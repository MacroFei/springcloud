package com.xlccc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //启用Eureka客户端
public class CloudProvider8002Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudProvider8002Application.class, args);
    }

}
