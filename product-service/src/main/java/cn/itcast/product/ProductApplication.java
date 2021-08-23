package cn.itcast.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: IntelliJ IDEA
 * @description 启动类
 * @author: zutlh
 **/
@SpringBootApplication
@EntityScan("cn.itcast.product.entity")
@EnableEurekaClient
public class ProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class,args);
        System.out.println("商品服务启动成功！");
    }
}
