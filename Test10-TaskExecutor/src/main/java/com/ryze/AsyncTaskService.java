package com.ryze;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by xueLai on 2019/3/28.
 */
@Service("asyncTaskService")
public class AsyncTaskService {

    @Async
    public void executeAsyncTask1(int i){
        System.out.println("异步任务1：" + i+"；Thread.currentThread().getName():"+Thread.currentThread().getName());
    }
    @Async
    public void executeAsyncTask2(int i){
        System.out.println("异步任务2：" + i+"；Thread.currentThread().getName():"+Thread.currentThread().getName());
    }
}
