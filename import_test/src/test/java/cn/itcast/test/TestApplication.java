package cn.itcast.test;

import cn.itcast.bean.EnableUserBean;
import cn.itcast.bean.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * @program: IntelliJ IDEA
 * @description
 * @author: zutlh
 **/
@EnableUserBean
public class TestApplication {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        //获取spring容器
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestApplication.class);
        User user = ac.getBean(User.class);
        System.out.println(user);
    }

}
