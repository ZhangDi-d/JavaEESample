package com.ryze;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by xueLai on 2019/4/8.
 * 现在JavaConfig配置方式在逐步取代xml配置方式。而WebApplicationInitializer可以看做是Web.xml的替代，它是一个接口。通过实现WebApplicationInitializer，在其中可以添加servlet，listener等，在加载Web项目的时候会加载这个接口实现类，从而起到web.xml相同的作用。
 *
 * 原文：https://blog.csdn.net/zq17865815296/article/details/79464403
 */
public class WebInit implements WebApplicationInitializer {
    //spring mvc的两种部署到Servlet容器的方式：web.xml 、WebApplicationInitializer(需要容器实现了Servlet 3.0+)
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebMVCStaticConfig.class); //注册
        ServletRegistration.Dynamic dispatch = servletContext.addServlet("dispatch", new DispatcherServlet(context));
        context.setServletContext(servletContext);
        dispatch.addMapping("/");
        dispatch.setLoadOnStartup(1);
    }


    //web.xml
    /**
    <web-app>
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>/WEB-INF/app-context.xml</param-value>
    </context-param>
    <servlet>
        <servlet-name>app</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value></param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>app</servlet-name>
        <url-pattern>/app/*</url-pattern>
    </servlet-mapping>
    </web-app>
     */

}
