package cn.itcast.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @program: IntelliJ IDEA
 * @description
 * @author: zutlh
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class GatewayServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayServerApplication.class,args);
    }
}
