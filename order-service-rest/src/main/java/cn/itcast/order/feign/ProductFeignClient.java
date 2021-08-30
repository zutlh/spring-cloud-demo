package cn.itcast.order.feign;

import cn.itcast.product.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 声明需要调用的微服务名称
 * @FeignClient
 *      * name: 服务提供者的名称
 *
 */
@FeignClient(name = "product-service")
public interface ProductFeignClient {
    /**
     * 配置需要调用的微服务接口
     */
    @RequestMapping(value = "/product/{id}",method = RequestMethod.GET)
    public Product findById(@PathVariable("id") Long id);
}
