package com.xlccc.config;

import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonConfig {
    @Bean
    public IRule ribbonRule() {
        //轮询 (RoundRobinRule)  （默认）

        //随机策略
        return new RandomRule();
        //响应时间权重（WeightedResponseTimeRule）响应时间越短的服务器被选中的可能性大
//        return new WeightedResponseTimeRule();
//        并发量小可用（BestAvailableRule）选取少并发量请求的服务器
//        return BestAvailableRule();
    }
}
