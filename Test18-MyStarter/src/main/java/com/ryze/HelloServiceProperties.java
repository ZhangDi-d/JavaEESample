package com.ryze;

import org.springframework.boot.context.properties.ConfigurationProperties;
/**
 * Created by xueLai on 2019/4/13.
 */
@ConfigurationProperties(prefix = "hello")
public class HelloServiceProperties {
    private static final String MSG = "world";
    private String msg = MSG;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
