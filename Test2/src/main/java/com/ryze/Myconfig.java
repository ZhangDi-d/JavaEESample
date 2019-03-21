package com.ryze;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

/**
 * Created by xueLai on 2019/3/21.
 */
@Configuration
public class Myconfig {
    @Bean("functionService")
    public FunctionService functionService(){
        return new FunctionService();
    }

    @Bean
    @DependsOn("functionService")
    public UserFunctionService userFunctionService(){
        UserFunctionService userFunctionService = new UserFunctionService();
        userFunctionService.setFunctionService(functionService());
        return userFunctionService;
    }
}
