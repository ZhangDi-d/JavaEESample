package com.ryze;

import org.springframework.context.ApplicationEvent;

/**
 * Created by xueLai on 2019/3/21.
 */
public class TestEvent extends ApplicationEvent {
    private String msg;

    public TestEvent(Object source) {
        super(source);
    }

    public TestEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
