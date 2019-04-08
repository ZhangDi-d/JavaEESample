spring mvc的两种部署到Servlet容器的方式：web.xml 、WebApplicationInitializer :

```$xslt
public class MyWebApplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
// Load Spring web application configuration
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        ac.register(SpringContent.class);
        ac.refresh();
 
        // Create and register the DispatcherServlet
        DispatcherServlet servlet = new DispatcherServlet(ac);
        ServletRegistration.Dynamic registration = servletContext.addServlet("mvc", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}

```

```$xslt
@ComponentScan(basePackages = "controller")
@Configuration
public class SpringContent {
 
    @Bean
    public org.springframework.web.servlet.view.InternalResourceViewResolver internalResourceViewResolver(){
        return new org.springframework.web.servlet.view.InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
    }
}

```
实现WebApplicationInitializer的方式不再需要编写web.xml，实现了WebApplicationInitializer的具体类的onStartup函数会在Servlet容器启动时自动被调用，从而实现了在方法内注册spring ioc容器以及DispatcherServlet。

--------------------- 

原文：https://blog.csdn.net/ab411919134/article/details/81561411 
