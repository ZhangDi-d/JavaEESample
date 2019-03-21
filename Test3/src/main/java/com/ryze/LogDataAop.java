package com.ryze;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.lang.reflect.Method;

/**
 * Created by xueLai on 2019/3/21.
 */
@Aspect
@Component
public class LogDataAop {

    @Pointcut("@annotation(com.ryze.LogAspect)")
    public void annotationPointCut(){

    }

    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        LogAspect annotation = method.getAnnotation(LogAspect.class);
        System.out.println("注解拦截："+annotation.name());
    }

    /**
     * 第一个星号表示返回类型，×表示所有类型，注意第一个星号和包名之间有空格
     * 后面的星号表示任意字符
     * 两个点表示任意个参数
     *
     * 参考  http://www.cnblogs.com/yansum/p/5898412.html
     * @param joinPoint
     */
    @Before("execution(* com.ryze.MethodService.*(..))")
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法规则式拦截："+method.getName());

    }
}
