package cn.itcast.bean;

import org.springframework.context.annotation.Bean;

/**
 * 没有spring注解
 *
 * @program: IntelliJ IDEA
 * @description
 * @author: zutlh
 **/
public class UserConfiguration {
    @Bean
    public User getUser() {
        User user = new User();
        user.setAge(18);
        user.setUsername("张三");
        return user;
    }
}
