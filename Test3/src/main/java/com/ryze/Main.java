package com.ryze;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by xueLai on 2019/3/21.
 */
public class Main {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        AnnotationService annotationService = context.getBean(AnnotationService.class);
        MethodService methodService = context.getBean(MethodService.class);

        annotationService.add();
        annotationService.delete();
        annotationService.select();
        annotationService.update();

        methodService.add();
    }
}
