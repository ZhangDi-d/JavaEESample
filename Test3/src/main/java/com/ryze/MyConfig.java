package com.ryze;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by xueLai on 2019/3/21.
 */
@Configuration
@ComponentScan("com.ryze")
@EnableAspectJAutoProxy
public class MyConfig {
}
