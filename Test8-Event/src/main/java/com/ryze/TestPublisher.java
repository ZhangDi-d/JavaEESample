package com.ryze;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by xueLai on 2019/3/21.
 */
@Component
public class TestPublisher   {
    @Autowired
    private ApplicationContext applicationContext;

    public void publishEvent(String msg){
        applicationContext.publishEvent(new TestEvent(this,msg));
    }
}
