package com.ryze;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * Created by xueLai on 2019/3/27.
 */
@Service("AwareService")
@PropertySource(value = "test.properties", encoding = "UTF-8")
public class AwareService implements BeanNameAware, BeanFactoryAware, ResourceLoaderAware, EnvironmentAware{
    private String beanName;
    private ResourceLoader resourceLoader;
    private Environment environment;

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }

    public void setBeanName(String s) {
        this.beanName=s;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public void output(){
        System.out.println("Bean的名称为：" + beanName);
        String property = environment.getProperty("spring.username");
        System.out.println("spring.username:"+property);
        Resource resource = resourceLoader.getResource("test.txt");
        try {
            System.out.println(IOUtils.toString(resource.getInputStream(),Charset.forName("UTF-8")));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
