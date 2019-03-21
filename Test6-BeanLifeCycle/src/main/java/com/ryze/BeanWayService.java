package com.ryze;

/**
 * Created by xueLai on 2019/3/21.
 */
public class BeanWayService {

    public void init(){
        System.out.println("BeanWayService-init()");
    }

    public BeanWayService() {
        System.out.println("BeanWayService-构造方法");
    }

    public void destory(){
        System.out.println("BeanWayService-destroy()");
    }
}
