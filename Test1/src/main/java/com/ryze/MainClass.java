package com.ryze;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by xueLai on 2019/2/16.
 */
public class MainClass {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        //context.scan("com.ryze");
        UseHelloService service = context.getBean(UseHelloService.class);
        //service.sayHello("zhangdi"); 并不会输出任何字符串
        System.out.println(service.sayHello("zhangdi"));
        context.close();
    }
}
