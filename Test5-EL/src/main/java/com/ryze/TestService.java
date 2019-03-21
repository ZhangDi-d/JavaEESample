package com.ryze;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by xueLai on 2019/3/21.
 */
@Service
public class TestService {
    //注入普通字符串
    @Value("王羲之")
    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
