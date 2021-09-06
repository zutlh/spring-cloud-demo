package cn.itcast.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @program: IntelliJ IDEA
 * @description Zuul启动类
 * @author: zutlh
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
// 开启zuul网关功能
@EnableZuulProxy
@EnableEurekaClient
public class ZuulServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulServerApplication.class,args);
    }
}
