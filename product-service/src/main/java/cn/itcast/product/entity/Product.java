package cn.itcast.product.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @program: IntelliJ IDEA
 * @description 商品实体类
 * @author: zutlh
 **/
@Data
@Entity(name = "tb_product")
public class Product {
    @Id
    private long id;
    private String productName;
    private Integer status;
    private BigDecimal price;
    private String productDesc;
    private String caption;
    private Integer inventory;


}
