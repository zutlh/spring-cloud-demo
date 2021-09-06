# spring-cloud-demo
## 用来了解SpringCloud架构的小应用

## @Retention注解作用
@Retention作用是定义被它所注解的注解保留多久，一共有三种策略，定义在RetentionPolicy枚举中.

从注释上看：

source：注解只保留在源文件，当Java文件编译成class文件的时候，注解被遗弃；被编译器忽略

class：注解被保留到class文件，但jvm加载class文件时候被遗弃，这是默认的生命周期

runtime：注解不仅被保存到class文件中，jvm加载class文件之后，仍然存在

这3个生命周期分别对应于：Java源文件(.java文件) ---> .class文件 ---> 内存中的字节码。
## @Documented
在自定义注解的时候可以使用@Documented来进行标注，如果使用@Documented标注了，在生成javadoc的时候就会把@Documented注解给显示出来。
## @Target
@Target(ElementType.TYPE)——接口、类、枚举、注解
@Target(ElementType.FIELD)——字段、枚举的常量
@Target(ElementType.METHOD)——方法
@Target(ElementType.PARAMETER)——方法参数
@Target(ElementType.CONSTRUCTOR) ——构造函数
@Target(ElementType.LOCAL_VARIABLE)——局部变量
@Target(ElementType.ANNOTATION_TYPE)——注解
@Target(ElementType.PACKAGE)——包

## 问题
order-service-feign
order-service-rest
获取不到product-service服务，报503 Service Unavailable] with root cause
hhh,太离谱了，本来以为是@LoadBalanced的问题，原来是因为我开了VPN导致的，但在开了VPN的情况下通过return restTemplate.getForObject("http://localhost:9001/product/"+id,Product.class);去访问没有问题
一使用Ribbon和Feign就访问不了，原因还是未知。

