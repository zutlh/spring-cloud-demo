package cn.itcast.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @program: IntelliJ IDEA
 * @description 启动类
 * @author: zutlh
 **/
@SpringBootApplication
@EntityScan("cn.itcast.order.entity")
@EnableEurekaClient
public class OrderApplication {
    /**
     * 使用spring提供的RestTemplate发送http请求到商品服务
     * 1.创建RestTemplate对象交给容器管理
     * 2.在使用的时候，调用其方法完成操作(getXX,postXXX)
     * @LoadBalanced: 是Ribbon提供的负载均衡的注解
     * @return
     */

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }
}
