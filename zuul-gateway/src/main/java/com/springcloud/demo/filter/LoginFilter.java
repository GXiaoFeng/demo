package com.springcloud.demo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class LoginFilter extends ZuulFilter {


    // 日志打印
    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 返回值可取：
     * pre：在请求路由之前执行
     * route：在请求路由时调用
     * post：请求路由之后调用， 也就是在route和errror过滤器之后调用
     * error：处理请求发生错误时调用
     *
     * @return pre
     */
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        //int值来定义过滤器的执行顺序，数值越小优先级越高
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        //该过滤器是否执行，true执行，false不执行
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        //获取请求参数token的值
        String token = request.getParameter("token");
        if (token == null) {

            logger.warn("此操作需要先登录系统...");
            // 拒绝访问
            context.setSendZuulResponse(false);
            // 响应状态吗
            context.setResponseStatusCode(200);
            try {
                context.getResponse().getWriter().write("token is empty");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        logger.info("通过，会进行路由转发。。。");
        return null;
    }
}
