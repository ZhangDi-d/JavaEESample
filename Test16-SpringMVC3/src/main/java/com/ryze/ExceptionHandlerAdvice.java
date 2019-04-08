package com.ryze;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by xueLai on 2019/4/8.
 */
@ControllerAdvice //@ControllerAdvice声明一个控制器建言，由于这个注解组合了@Component注解，这个这个类会自动注册为Spring容器中的Bean
public class ExceptionHandlerAdvice {
    //@ExceptionHandler用来设置拦截条件，这里表示拦截所有的Exception
    @ExceptionHandler(value = Exception.class)
    public ModelAndView exception(Exception e, WebRequest request) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMsg", e.getMessage());
        return modelAndView;
    }

    //所有使用了@RequestMapping注解的方法都可以获取到该键值对/
    //在这个方法中我们向Model中绑定键值对，绑定完成之后，在任何Controller中我们都可以通过给方法的参数设定@ModelAttribute注解来访问这里存入的值，相当于这里的值是一个全局变量
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("msg", "额外信息");
    }

    //有的时候我们需要预处理前台传来的参数，比如说禁止掉某一个参数，这个也可以统一处理，OK，继续在ExceptionHandlerAdvice方法中添加方法
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id");
    }

}
