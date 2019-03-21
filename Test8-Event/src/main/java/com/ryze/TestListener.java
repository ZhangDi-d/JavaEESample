package com.ryze;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by xueLai on 2019/3/21.
 */
@Component
public class TestListener implements ApplicationListener<TestEvent> {

    public void onApplicationEvent(TestEvent testEvent) {
        System.out.println("收到消息:"+testEvent.getMsg());
    }
}
