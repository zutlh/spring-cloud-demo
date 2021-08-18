package cn.itcast.bean;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @program: IntelliJ IDEA
 * @description
 * @author: zutlh
 **/
public class UserImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //获取配置类的名称
        return new String[]{UserConfiguration.class.getName()};
    }
}
