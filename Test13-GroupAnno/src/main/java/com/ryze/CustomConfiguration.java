package com.ryze;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

/**
 * Created by xueLai on 2019/4/3.
 */
@Target({ElementType.TYPE})
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Configuration
@ComponentScan
public @interface CustomConfiguration {
    String[] value();
}
