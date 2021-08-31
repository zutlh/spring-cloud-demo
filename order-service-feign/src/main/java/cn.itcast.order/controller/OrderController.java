package cn.itcast.order.controller;

import cn.itcast.order.feign.ProductFeignClient;
import cn.itcast.product.entity.Product;

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
public class OrderController {


    @Autowired
    private ProductFeignClient productFeignClient;

    @RequestMapping(value = "/buy/{id}",method = RequestMethod.GET)
    public Product findById(@PathVariable Long id){
        Product product = null;
        product = productFeignClient.findById(id);
        return product;
    }

}
