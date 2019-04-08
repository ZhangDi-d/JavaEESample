package com.ryze;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by xueLai on 2019/4/8.
 */
@Controller
@RequestMapping("/index1")
public class HelloController {
    @RequestMapping("/index2")
    public String hello(HttpServletRequest request) {
        System.out.println(request.getParameter("username"));
        return "index";
    }

}
