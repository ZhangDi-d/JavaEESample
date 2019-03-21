package com.ryze;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by xueLai on 2019/3/21.
 */
@Configuration
@ComponentScan("com.ryze")
public class MyConfig {
    @Bean(initMethod = "init",destroyMethod = "destory")
    BeanWayService beanWayService() {
        return new BeanWayService();
    }

    @Bean
    JSR250WayService jsr250WayService() {
        return new JSR250WayService();
    }
}
