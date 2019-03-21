package com.ryze;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by xueLai on 2019/3/21.
 */
public class Main {
    public static void main(String[] args) {


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        TestPublisher bean = context.getBean(TestPublisher.class);
        bean.publishEvent("hello");
        //无效
//        ApplicationEventPublisher publisher = (ApplicationEventPublisher)context.getBean("applicationEventPublisher");
//        publisher.publishEvent(new TestEvent( "1","Testpublisher2"));
        context.close();


    }
}
