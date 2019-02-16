package com.ryze;

import org.springframework.stereotype.Service;

/**
 * Created by xueLai on 2019/2/16.
 */
@Service
public class HelloService {
    public String sayHello(String word){
        return "hello,"+word+"!";
    }
}
