package com.xlccc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient // 启用Eureka客户端
@EnableFeignClients(basePackages = "com.xlccc.service") // 启用Feign客户端,扫描指定包下所有feign注解
public class CloudConsumer8080Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumer8080Application.class, args);
    }

}
