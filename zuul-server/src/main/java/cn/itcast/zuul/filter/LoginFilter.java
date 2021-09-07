package cn.itcast.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: IntelliJ IDEA
 * @description 自定义的zuul过滤器
 * @author: zutlh
 **/
@Component
public class LoginFilter extends ZuulFilter {
    /**
     * 定义过滤类型
     *  pre routing post error
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 指定过滤器的执行顺序
     *  返回值越小，执行顺序越高
     * @return
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * 当前过滤器是否生效
     *  true: 使用此过滤器
     *  false: 不使用
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 指定过滤器中的业务逻辑
     * 身份认证：
     *  1、所有的请求需要携带一个参数：access-token
     *  2、获取request请求
     *  3、通过request获取参数access-token
     *  4、判断token是否为空
     *  4.1、token==null：身份验证失败
     *  4.2、token!=null：执行后续操作
     *  在zuul网关中，通过RequestContext的上下文对象,可以获取对象request
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        // 1、获取zuul提供的上下文对象RequestContext
        RequestContext context = RequestContext.getCurrentContext();
        // 2、从RequestContext中获取request
        HttpServletRequest request = context.getRequest();
        // 3、获取请求参数access-token
        String token = request.getParameter("access-token");
        // 4、判断
        if (token == null){
            context.setSendZuulResponse(false);//拦截请求
            context.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
        }
        return null;
    }
}
