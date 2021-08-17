package cn.itcast.product.service;

import cn.itcast.product.entity.Product;
import org.springframework.stereotype.Service;


public interface ProductService {
    /**
     * 根据id查询
     */

    Product findById(long id);

    /**
     * 保存
     */

    void save(Product product);

    /**
     * 更新
     */

    void update(Product product);

    /**
     * 删除
     */
    void delete(Long id);

}
