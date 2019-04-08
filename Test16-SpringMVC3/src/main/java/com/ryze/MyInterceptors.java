package com.ryze;

import org.omg.PortableInterceptor.Interceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xueLai on 2019/4/8.
 * 拦截器在JavaEE开发中还是非常重要的，乱码解决、权限控制等等都会用到，使用Servlet的时候有一个Filter类用来进行过滤，那么SpringMVC也在这方面给我们提供了相应的解决方案。
 */

public class MyInterceptors implements HandlerInterceptor {
    private Logger logger  = LoggerFactory.getLogger(MyInterceptors.class);
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        logger.info("preHandle");
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        logger.info("postHandle");
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        logger.info("afterCompletion");
    }
}
