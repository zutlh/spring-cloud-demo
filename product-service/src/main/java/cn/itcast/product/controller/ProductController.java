package cn.itcast.product.controller;

import cn.itcast.product.entity.Product;
import cn.itcast.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @program: IntelliJ IDEA
 * @description
 * @author: zutlh
 **/

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Value("${server.port}")
    private String port;
    @Value("${spring.cloud.client.ip-address}")
    private String ip;


    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Product findById(@PathVariable Long id){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Product product = productService.findById(id);
        product.setProductName("访问的服务地址"+ip+":"+port);
        return product;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(@RequestBody Product product){
        productService.save(product);
        return "保存成功";
    }
}
