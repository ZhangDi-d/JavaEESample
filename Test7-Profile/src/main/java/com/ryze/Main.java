package com.ryze;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Profile;

/**
 * Created by xueLai on 2019/3/21.
 */
public class Main {
    public static void main(String[] args){
        //https://www.cnblogs.com/ashleyboy/p/9662119.html
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("prod");
        context.register(ProfileConfig.class);
        context.refresh();

        TestBean bean = context.getBean(TestBean.class);
        System.out.println(bean.getContent());
        context.close();

        AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext();
        context2.getEnvironment().setActiveProfiles("dev");
        context2.register(ProfileConfig.class);
        context2.refresh();

        TestBean bean2 = context2.getBean(TestBean.class);
        System.out.println(bean2.getContent());

        context2.close();
    }
}
