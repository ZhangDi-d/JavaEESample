package com.ryze;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by xueLai on 2019/3/28.
 */
@Configuration
@ComponentScan("com.ryze")
@EnableScheduling
public class MyConfig {
}
