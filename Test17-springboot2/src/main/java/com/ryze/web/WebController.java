package com.ryze.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xueLai on 2019/4/13.
 */
@RestController
@RequestMapping("/web")
public class WebController {
    @Value("${book.name}")
    private String bookName;

    @RequestMapping("/hello")
    public String hello() {
        return "hello,springboot!";
    }

    @RequestMapping("/hello2")
    public String hello2() {
        return "hello2," + bookName;
    }
}
