package cn.itcast.order.feign;

import cn.itcast.product.entity.Product;
import org.springframework.stereotype.Component;

/**
 * @program: IntelliJ IDEA
 * @description ProductFeignClient实现类
 * @author: zutlh
 **/
@Component
public class ProductFeignClientCallback implements ProductFeignClient {
    /**
     * 熔断降级的方法
     * @param id
     * @return
     */
    public Product findById(Long id) {
        Product product = new Product();
        product.setProductName("Feign调用触发了熔断降级方法");
        return product;
    }
}
