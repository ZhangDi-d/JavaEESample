package com.ryze;


import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * Created by xueLai on 2019/3/21.
 */
@Configuration
@ComponentScan("com.ryze")
@PropertySource(value="test1.properties",encoding = "utf-8")
public class ELConfig {
    @Value("I Love You!")
    private String normal;
    @Value("#{systemProperties['os.name']}")
    private String osName;
    @Value("#{systemEnvironment['os.arch']}")
    private String osArch;
    @Value("#{T(java.lang.Math).random()*100}")
    private double randomNumber;
    @Value("#{testService.author}")
    private String author;
    @Value("test.txt")
    private Resource testFile;

    //通过@Value("${}") 可以获取对应属性文件中定义的属性值
    @Value("https://www.baidu.com/")
    private Resource testUrl;
    @Value("${spring.username}")
    private String su;
    @Value("${spring.password}")
    private String sp;
    @Value("${spring.nickname}")  //@Value("#{spring.nickname}") 会报错
    private String sn;
    private Environment environment;

    public void output() {
        try {
            System.out.println(normal);
            System.out.println(osName);
            System.out.println(osArch);
            System.out.println(randomNumber);
            System.out.println(author);
            System.out.println(IOUtils.toString(testFile.getInputStream(),"UTF-8"));
            //访问网址
            System.out.println(IOUtils.toString(testUrl.getInputStream(),"UTF-8"));
            //获取网址
            System.out.println("testUrl.getURL():"+testUrl.getURL());
            System.out.println(su);
            System.out.println(sp);
            System.out.println(sn);
            System.out.println(environment.getProperty("spring.nickname"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
