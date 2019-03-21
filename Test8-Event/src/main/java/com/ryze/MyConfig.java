package com.ryze;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;

/**
 * Created by xueLai on 2019/3/21.
 */
@Configuration
@ComponentScan("com.ryze")
public class MyConfig {
    @Bean("applicationEventPublisher")
    public ApplicationEventPublisher applicationEventPublisher(){
        return new ApplicationEventPublisher() {
            public void publishEvent(ApplicationEvent applicationEvent) {

            }

            public void publishEvent(Object o) {

            }
        };
    }
}
