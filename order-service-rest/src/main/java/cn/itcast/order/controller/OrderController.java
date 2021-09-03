package cn.itcast.order.controller;

import cn.itcast.product.entity.Product;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @program: IntelliJ IDEA
 * @description
 * @author: zutlh
 **/
@RestController
@RequestMapping("/order")
/**
 * @DefaultProperties: 指定此接口中公共的熔断设置
 * 如果在@DefaultProperties指定了公共的降级方法
 * 在@HystrixCommand不需要单独指定了
 */
@DefaultProperties(defaultFallback = "defaultFallback")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;


    /**
     * 基于Ribbon的形式调用远程的微服务
     * 1、使用@loadbalacned声明RestTemplate
     * 2、使用服务名称替换ip地址
     *
     * @param id
     * @return
     */
    /**
     * 使用注解配置熔断保护
     * fallbackmethod：配置熔断之后的降级方法
     *
     * @param id
     * @return
     */
//    @HystrixCommand()
    @RequestMapping(value = "/buy/{id}", method = RequestMethod.GET)
    public Product findById(@PathVariable Long id) {
        if(id!=1){
            throw new RuntimeException("服务器异常");
        }
        Product product = null;
        product = restTemplate.getForObject("http://product-service/product/" + id, Product.class);
        return product;
    }
    /**
     * 指定统一降级方法
     *  参数：没有参数
     */
    public Product defaultFallback(){
        Product product = new Product();
        product.setProductName("触发统一的降级方法");
        return product;
    }

    /**
     * 降级方法
     * 和需要收到保护的方法的返回值一致
     */
    public Product orderFallback(Long id) {
        Product product = new Product();
        product.setProductName("触发降级方法");
        return product;
    }
}


