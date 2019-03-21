package com.ryze;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * Created by xueLai on 2019/3/21.
 */
public class Main {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Myconfig.class);
        ScopeTest bean1 = context.getBean(ScopeTest.class);
        ScopeTest bean2 = context.getBean(ScopeTest.class);
        System.out.println(bean1.equals(bean2)); //singleton -true  prototype-false
        context.close();
    }
}
