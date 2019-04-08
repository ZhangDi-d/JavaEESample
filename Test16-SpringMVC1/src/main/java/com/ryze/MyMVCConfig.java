package com.ryze;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by xueLai on 2019/4/8.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.ryze")
public class MyMVCConfig {
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        //前缀  由于项目编译之后运行的时候，index.jsp 文件是处于/WEB-INF/classes/views/目录下的，所以前缀为/WEB-INF/classes/views/。
        viewResolver.setPrefix("/WEB-INF/classes/views/");
        //后缀
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;

    }
}
