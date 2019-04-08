package com.ryze;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.slf4j.*;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by xueLai on 2019/3/28.
 */
@Configuration
@ComponentScan("com.ryze")
@EnableAsync //开启异步
public class TaskExecutorConfig implements AsyncConfigurer {
    private final Logger log = LoggerFactory.getLogger(TaskExecutorConfig.class);
    public Executor getAsyncExecutor() {
        log.debug("Creating Async Task Executor");
        //ThreadPoolTaskExecutor是一个spring的线程池技术，其实，它的实现方式完全是使用ThreadPoolExecutor进行实现（有点类似于装饰者模式。当然Spring提供的功能更加强大些，因为还有定时调度功能）。
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10); //核心线程数
        executor.setMaxPoolSize(20);  //最大线程数
        executor.setQueueCapacity(1000); //队列大小
        executor.setKeepAliveSeconds(300); //线程最大空闲时间
        executor.setThreadNamePrefix("ics-Executor-"); ////指定用于新创建的线程名称的前缀。
        executor.setRejectedExecutionHandler(
                new ThreadPoolExecutor.CallerRunsPolicy()); // 拒绝策略
        executor.initialize();
        return executor;

        /*
         * 其中我们主要注意的就是拒绝策略方法：setRejectedExecutionHandler（），拒绝策略常用有有这四种
         *
         * ThreadPoolExecutor.AbortPolicy 丢弃任务并抛出RejectedExecutionException异常(默认)。
         * ThreadPoolExecutor.DiscardPolic 丢弃任务，但是不抛出异常。
         * ThreadPoolExecutor.DiscardOldestPolicy 丢弃队列最前面的任务，然后重新尝试执行任务
         * ThreadPoolExecutor.CallerRunsPolic 由调用线程处理该任务
         */

    }

    public Executor getAsyncExecutor2(){
        log.debug("Creating Async Task Executor------222222");
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,20,300, TimeUnit.SECONDS,
                new SynchronousQueue(),new ThreadPoolExecutor.CallerRunsPolicy());
//        threadPoolExecutor.setCorePoolSize(10); //核心线程数
//        threadPoolExecutor.setMaxPoolSize(20);  //最大线程数
//        threadPoolExecutor.setQueueCapacity(1000); //队列大小
//        threadPoolExecutor.setKeepAliveSeconds(300); //线程最大空闲时间
//        threadPoolExecutor.setThreadNamePrefix("ics-Executor-"); ////指定用于新创建的线程名称的前缀。
//        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy()); // 拒绝策略
//        threadPoolExecutor.initialize();
        /**
         * ArrayBlockingQueue：是一个基于数组结构的有界阻塞队列，此队列按 FIFO（先进先出）原则对元素进行排序。
         * LinkedBlockingQueue：一个基于链表结构的阻塞队列，此队列按FIFO （先进先出） 排序元素，吞吐量通常要高于ArrayBlockingQueue。静态工厂方法Executors.newFixedThreadPool()使用了这个队列
         * SynchronousQueue：一个不存储元素的阻塞队列。每个插入操作必须等到另一个线程调用移除操作，否则插入操作一直处于阻塞状态，吞吐量通常要高于LinkedBlockingQueue，静态工厂方法Executors.newCachedThreadPool使用了这个队列。
         * PriorityBlockingQueue：一个具有优先级的无限阻塞队列。
         */
        return threadPoolExecutor;

    }

    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new SimpleAsyncUncaughtExceptionHandler();
    }
}
