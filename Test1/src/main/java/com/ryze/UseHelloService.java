package com.ryze;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by xueLai on 2019/2/16.
 */
//这几种注解效果此情景下效果相同
//@Service
//@Component
//@Controller
@Repository
public class UseHelloService {
    @Autowired
    public HelloService helloService;

    public String sayHello(String word) {
        return helloService.sayHello(word);
    }
}
