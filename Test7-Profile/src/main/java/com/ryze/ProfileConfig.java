package com.ryze;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by xueLai on 2019/3/21.
 */
@Configuration
public class ProfileConfig {
    @Bean
    @Profile("dev")
    public TestBean devBean(){
        return new TestBean("dev");
    }
    @Bean
    @Profile("prod")
    public TestBean prodBean(){
        return new TestBean("prod");
    }
}
