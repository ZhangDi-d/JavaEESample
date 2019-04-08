#### 静态资源映射:
我们都知道在SpringMVC中静态资源文件都是直接访问的，而不需要映射，这些静态资源主要包括js文件、css文件、图片文件等，那么这个需要我们单独处理，否则系统会找不到路径。OK，这个问题的解决也很容易，假设我有一张图片放在src/main/resources/assets/img目录下，然后想在jsp页面中将其展示出来

我们创建MVCConfig类，作用还是和上文一样，不同的是这次我们继承自WebMvcConfigurerAdapter，然后重写WebMvcConfigurerAdapter类中的addResourceHandlers方法来解决这个问题



#### 拦截器使用
拦截器的定义我们可以通过继承HandlerInterceptorAdapter或者实现HandlerInterceptor接口
然后在MVCConfig类中添加addInterceptors方法注册拦截器，如下：
```java

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptors());
    }
    @Bean
    public MyInterceptors myInterceptors() {
        return new MyInterceptors();
    }
```


#### 全局配置问题
全局资源的配置问题，我们可以通过@ControllerAdvice来把控制器的全局配置放在同一个位置，这样我们可以统一处理下面几个问题：

1 .全局异常处理 
2 .预设键值对绑定到Model中 
3 .预处理前台请求参数