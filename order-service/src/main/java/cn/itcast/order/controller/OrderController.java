package cn.itcast.order.controller;

import cn.itcast.order.command.OrderCommand;
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
    private RestTemplate restTemplate;


    /**
     * 使用orderCommand调用远程服务
     * @param id
     * @return
     */
    @RequestMapping(value = "/buy/{id}",method = RequestMethod.GET)
    public Product findById(@PathVariable Long id){
//        Product product = new Product();
//        product = restTemplate.getForObject("http://localhost:9001/product/" + id, Product.class);
//        return product;
        return new OrderCommand(restTemplate,id).execute();
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String findOrder(@PathVariable Long id){
        System.out.println(Thread.currentThread().getName());
        return "根据ID查询订单";
    }


    /**
     * 参数：商品id
     * 通过订单系统，调用商品服务根据id查询商品信息
     * 1.需要配置商品对象
     * 2.需要调用商品服务
     * 使用Java中的urlconnection，httpclient，okhttp
     * @param id
     * @return
     */
//    @RequestMapping(value = "/buy/{id}",method = RequestMethod.GET)
//    public Product findById(@PathVariable Long id){
//
//        //调用discoveryClient方法
//        // 以调用服务名称获取所有的元数据
//        List<ServiceInstance> instances = discoveryClient.getInstances("product-service");
//        // 获取唯一的元数据
//        ServiceInstance instance = instances.get(0);
//        Product product = null;
//        product = restTemplate.getForObject("http://"+instance.getHost()+":"+instance.getPort()+"/product/"+id,Product.class);
//        return product;
//    }

}
