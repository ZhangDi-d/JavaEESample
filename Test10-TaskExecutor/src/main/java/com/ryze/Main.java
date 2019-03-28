package com.ryze;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by xueLai on 2019/3/28.
 */
public class Main {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        AsyncTaskService asyncTaskService = (AsyncTaskService)context.getBean("asyncTaskService");
//        asyncTaskService.executeAsyncTask1(1);
//        asyncTaskService.executeAsyncTask2(2);
        for (int i = 0; i < 10; i++) {
            asyncTaskService.executeAsyncTask1(i);
            asyncTaskService.executeAsyncTask2(i);
        }
        context.close();
    }

}
