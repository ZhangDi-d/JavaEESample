### Executor, ExecutorService 和 Executors 间的不同

>java.util.concurrent.Executor, java.util.concurrent.ExecutorService, java.util.concurrent. Executors 这三者均是 Java Executor 框架的一部分，用来提供线程池的功能。因为创建和管理线程非常心累，并且操作系统通常对线程数有限制，所以建议使用线程池来并发执行任务，而不是每次请求进来时创建一个线程。使用线程池不仅可以提高应用的响应时间，还可以避免”java.lang.OutOfMemoryError: unable to create new native thread” 之类的错误。

>在 Java 1.5 时，开发者需要关心线程池的创建和管理，但在 Java 1.5 之后 Executor 框架提供了多种内置的线程池,例如：FixedThreadPool(包含固定数目的线程)，CachedThreadPool(可根据需要创建新的线程)等等

#### Executor
Executor, ExecutorService, 和 Executors 最主要的区别是 ***Executor是一个抽象层面的核心接口***(大致代码如下):
```java
public interface Executor {
    void execute(Runnable command);
}
```
不同于 java.lang.Thread 类将任务和执行耦合在一起， Executor 将任务本身和执行任务分离，可以阅读 difference between Thread and Executor 来了解 Thread 和 Executor 间更多的不同。

#### ExecutorService
ExecutorService 接口 对 Executor 接口进行了扩展，提供了返回 Future 对象，终止，关闭线程池等方法。当调用 shutDown 方法时，线程池会停止接受新的任务，但会完成正在 pending 中的任务。

Future 对象提供了异步执行，这意味着无需等待任务执行的完成，只要提交需要执行的任务，然后在需要时检查 Future 是否已经有了结果，如果任务已经执行完成，就可以通过 Future.get() 方法获得执行结果。需要注意的是，Future.get() 方法是一个阻塞式的方法，如果调用时任务还没有完成，会等待直到任务执行结束。

通过 ExecutorService.submit() 方法返回的 Future 对象，还可以取消任务的执行。Future 提供了 cancel() 方法用来取消执行 pending 中的任务。
ExecutorService 部分代码如下：
```java
public interface ExecutorService extends Executor {
    void shutdown();
    <T> Future<T> submit(Callable<T> task);
    <T> Future<T> submit(Runnable task, T result);
    <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException;
}
```
Executors
Executors 是一个工具类，类似于 Collections。提供工厂方法来创建不同类型的线程池，比如 FixedThreadPool 或 CachedThreadPool。

Executors 部分代码：
```java
public class Executors {
    public static ExecutorService newFixedThreadPool(int nThreads) {
        return new ThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());
        }
         
     public static ExecutorService newCachedThreadPool() {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        }
}
```

#### 下面详细看一下三者的区别：

#### Executor vs ExecutorService vs Executors
正如上面所说，这三者均是 Executor 框架中的一部分。Java 开发者很有必要学习和理解他们，以便更高效的使用 Java 提供的不同类型的线程池。总结一下这三者间的区别，以便大家更好的理解：

Executor 和 ExecutorService 区别:
- Executor 和 ExecutorService 这两个接口主要的区别是：ExecutorService 接口继承了 Executor 接口，是 Executor 的子接口
- Executor 和 ExecutorService 第二个区别是：Executor 接口定义了 execute()方法用来接收一个Runnable接口的对象，而 ExecutorService 接口中的 submit()方法可以接受Runnable和Callable接口的对象。
- Executor 和 ExecutorService 接口第三个区别是 Executor 中的 execute() 方法不返回任何结果，而 ExecutorService 中的 submit()方法可以通过一个 Future 对象返回运算结果。
- Executor 和 ExecutorService 接口第四个区别是除了允许客户端提交一个任务，ExecutorService 还提供用来控制线程池的方法。比如：调用 shutDown() 方法终止线程池。可以通过 《Java Concurrency in Practice》 一书了解更多关于关闭线程池和如何处理 pending 的任务的知识。

Executors 类提供工厂方法用来创建不同类型的线程池。比如: newSingleThreadExecutor() 创建一个只有一个线程的线程池，newFixedThreadPool(int numOfThreads)来创建固定线程数的线程池，newCachedThreadPool()可以根据需要创建新的线程，但如果已有线程是空闲的会重用已有线程。


总结
下表列出了 Executor 和 ExecutorService 的区别：
![](http://incdn1.b0.upaiyun.com/2017/06/f50e3bbcff08e62e29299f2c5a65733f.png)

译者注
个人觉得，利用 Executors 类提供的工厂方法来创建一个线程池是很方便，但对于需要根据实际情况自定义线程池某些参数的场景，就不太适用了。

举个例子：
当线程池中的线程均处于工作状态，并且线程数已达线程池允许的最大线程数时，就会采取指定的饱和策略来处理新提交的任务。总共有四种策略：

- AbortPolicy: 直接抛异常
- CallerRunsPolicy: 用调用者的线程来运行任务
- DiscardOldestPolicy: 丢弃线程队列里最近的一个任务，执行新提交的任务
- DiscardPolicy 直接将新任务丢弃

如果使用 Executors 的工厂方法创建的线程池，那么饱和策略都是采用默认的 AbortPolicy，所以如果我们想当线程池已满的情况，使用调用者的线程来运行任务，就要自己创建线程池，指定想要的饱和策略，而不是使用 Executors 了。

所以我们可以根据需要创建 ThreadPoolExecutor(ExecutorService接口的实现类) 对象，自定义一些参数，而不是调用 Executors 的工厂方法创建。

当然，在使用 Spring 框架的项目中，也可以使用 Spring 提供的 ThreadPoolTaskExecutor 类来创建线程池。ThreadPoolTaskExecutor 与 ThreadPoolExecutor 类似，也提供了许多参数用来自定义线程池，比如：核心线程池大小，线程池最大数量，饱和策略，线程活动保持时间等等。

### 最佳实践
阿里发布的 Java开发手册中强制线程池不允许使用 Executors 去创建，而是通过 ThreadPoolExecutor 的方式，这样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险.

```java
    public ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue,
                              ThreadFactory threadFactory,
                              RejectedExecutionHandler handler) 
```

- corePoolSize - 线程池核心池的大小。
- maximumPoolSize - 线程池的最大线程数。
- keepAliveTime - 当线程数大于核心时，此为终止前多余的空闲线程等待新任务的最长时间。
- unit - keepAliveTime 的时间单位。
- workQueue - 用来储存等待执行任务的队列。
- threadFactory - 线程工厂。
- handler - 拒绝策略。

#### 关注点1 线程池大小
线程池有两个线程数的设置，一个为核心池线程数，一个为最大线程数。
在创建了线程池后，默认情况下，线程池中并没有任何线程，等到有任务来才创建线程去执行任务，除非调用了prestartAllCoreThreads()或者prestartCoreThread()方法
当创建的线程数等于 corePoolSize 时，会加入设置的阻塞队列。当队列满时，会创建线程执行任务直到线程池中的数量等于maximumPoolSize。

#### 关注点2 适当的阻塞队列
```java
java.lang.IllegalStateException: Queue full
方法 抛出异常 返回特殊值 一直阻塞 超时退出
插入方法 add(e) offer(e) put(e) offer(e,time,unit)
移除方法 remove() poll() take() poll(time,unit)
检查方法 element() peek() 不可用 不可用
```
ArrayBlockingQueue ：一个由数组结构组成的有界阻塞队列。
LinkedBlockingQueue ：一个由链表结构组成的有界阻塞队列。
PriorityBlockingQueue ：一个支持优先级排序的无界阻塞队列。
DelayQueue： 一个使用优先级队列实现的无界阻塞队列。
SynchronousQueue： 一个不存储元素的阻塞队列。
LinkedTransferQueue： 一个由链表结构组成的无界阻塞队列。
LinkedBlockingDeque： 一个由链表结构组成的双向阻塞队列。


#### 关注点3 明确拒绝策略
ThreadPoolExecutor.AbortPolicy: 丢弃任务并抛出RejectedExecutionException异常。 (默认)
ThreadPoolExecutor.DiscardPolicy：也是丢弃任务，但是不抛出异常。
ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
ThreadPoolExecutor.CallerRunsPolicy：由调用线程处理该任务

说明：Executors 各个方法的弊端：
1）newFixedThreadPool 和 newSingleThreadExecutor:
主要问题是堆积的请求处理队列可能会耗费非常大的内存，甚至 OOM。
2）newCachedThreadPool 和 newScheduledThreadPool:
主要问题是线程数最大数是 Integer.MAX_VALUE，可能会创建数量非常多的线程，甚至 OOM。


ThreadPoolTaskExecutor是一个spring的线程池技术，其实，它的实现方式完全是使用ThreadPoolExecutor进行实现（有点类似于装饰者模式。当然Spring提供的功能更加强大些，因为还有定时调度功能）。

----
来源:
http://www.importnew.com/24923.html
https://blog.csdn.net/qq_33300570/article/details/78394188










ThreadPoolExecutor 创建线程池: 
![在这里插入图片描述](https://img-blog.csdnimg.cn/2019040814373615.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1NoZWxsZXlMaXR0bGVoZXJv,size_16,color_FFFFFF,t_70)

ThreadPoolTaskExecutor 创建线程池: 
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190408143938841.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1NoZWxsZXlMaXR0bGVoZXJv,size_16,color_FFFFFF,t_70)

