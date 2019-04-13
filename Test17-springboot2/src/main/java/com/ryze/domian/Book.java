package com.ryze.domian;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by xueLai on 2019/4/13.
 */


@Data
@Component
@PropertySource("classpath:book.properties")
//@ConfigurationProperties(prefix = "book",locations = "classpath:book.properties") 这种方式在Springboot2中已经取消了Location了
public class Book {
    private String name;
    private String author;
    private String price;

}
