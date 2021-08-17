package cn.itcast.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @program: IntelliJ IDEA
 * @description 启动类
 * @author: zutlh
 **/
@SpringBootApplication
@EntityScan("cn.itcast.order.entity")
public class OrderApplication {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }
}
