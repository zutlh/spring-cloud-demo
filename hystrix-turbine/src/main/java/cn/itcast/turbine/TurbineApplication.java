package cn.itcast.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @program: IntelliJ IDEA
 * @description 启动类
 * @author: zutlh
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//turbine配置
@EnableTurbine
@EnableHystrixDashboard
public class TurbineApplication {
    public static void main(String[] args) {
        SpringApplication.run(TurbineApplication.class,args);
    }
}
