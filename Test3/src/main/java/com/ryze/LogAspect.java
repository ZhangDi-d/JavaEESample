package com.ryze;

import java.lang.annotation.*;

/**
 * Created by xueLai on 2019/3/21.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogAspect {
    String name() default  "";

    Enumlog action() ;

    public enum Enumlog{
        ADD,UPDATE,DELETE,SELECT
    }
}
