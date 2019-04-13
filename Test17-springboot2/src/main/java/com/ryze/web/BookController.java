package com.ryze.web;

import com.ryze.domian.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by xueLai on 2019/4/13.
 */

@RestController
@RequestMapping("book")
public class BookController {
    @Resource
    private Book book;

    //未生效
    @RequestMapping("/getBookInfo")
    public String getBookInfo(){
        return book.toString();
    }
}
