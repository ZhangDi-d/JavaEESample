package com.ryze;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by xueLai on 2019/4/3.
 */
public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        TestBean bean = context.getBean(TestBean.class);
        bean.output();
        context.close();
    }
}
