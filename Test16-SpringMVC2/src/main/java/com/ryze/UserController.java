package com.ryze;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by xueLai on 2019/4/8.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);
    @ResponseBody
    @RequestMapping(produces = "text/plain;charset=UTF-8")//produces描述的是响应的头信息的Content-Type字段
    public String user(HttpServletRequest request){
        logger.info("url:"+request.getRequestURL()); //url:http://localhost:8080/user
        logger.info("uri:"+request.getRequestURI()); //uri:/user
        return "url:"+request.getRequestURL()+"can access";
    }

    //http://localhost:8080/user/user/张三
    @ResponseBody
    @RequestMapping(value = "/user/{str}",produces = "text/plain;charset=UTF-8")
    public String pathVar(@PathVariable String str, HttpServletRequest request) {
        return "url:" + request.getRequestURL() + " can access , str is " + str;
    }

    //http://localhost:8080/user/rp?id=100
    @ResponseBody
    @RequestMapping(value = "/rp",produces = "text/plain;charset=UTF-8")
    public String requestParams(long id, HttpServletRequest request) {
        //url:http://localhost:8080/user/rp can access , username is :100
        return "url:" + request.getRequestURL() + " can access , username is :" + id;
    }

    //如果想给服务端返回一个json字符串或者xml字符串，直接返回一个对象即可，至于这个对象最终会被转为json还是xml，我们可以通过produces = "application/json;charset=UTF-8"或者produces = "application/xml;charset=UTF-8"来定义。
    // //http://localhost:8080/user/json?username=%E5%BC%A0%E4%B8%89&password=123
    @ResponseBody
    @RequestMapping(value = "/json", produces = "application/json;charset=UTF-8")
    public String passObj(UserBean userBean,HttpServletRequest request){
        Gson gson = new Gson();
        return gson.toJson(userBean);

    }

    @ResponseBody
    @RequestMapping(value = "/getJson",produces = "application/json;charset=UTF-8")
    public UserBean passObj(UserBean userBean) {
        return userBean;
    }

    //http://localhost:8080/user/n1
    //http://localhost:8080/user/n2
    @ResponseBody
    @RequestMapping(value = {"/n1","/n2"},produces = "text/plain;charset=UTF-8")
    public String group() {
        //不同路径定位到同一方法
        return "不同路径定位到同一方法";
    }

}
