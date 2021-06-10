package com.gt.project.model.test;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
* @Param
* @description   线程的生命周期：state：情形
 * 1，NEW：尚未启动的线程的线程状态。
 *
 * 2，Runnable：可运行的线程状态。可运行程序中的线程状态在java虚拟机中执行，但是  这个线程可能等待操作系统提供的其他资源  分到时间片
 *
 * 3，BLOCKED：线程阻塞等待监视器锁的线程状态。处于阻塞状态的线程正在等待监视器锁进入同步阻塞方法，或者调用wait()方法后重新进入同步阻塞方法。
 *
 * 4，WAITING：等待线程的线程状态》由于调用一下的方法之一：wait(),join(),LockSupportpark(),处于等待状态的线程正在等待另一个线程执行特定操作。
 * 例如，一个线程在一个对象上调用了wait()正在等待另一个线程调用notify()或者notifyAll()在那个对象上。调用join（）的线程正在等待指定的线程终止。
 *
 * * 5, TIMED_WAITING 具有指定等待时间的等待线程得线程状态，由于使用使用指定的正等待时间调用一下方法之一，
 *          *   <li>{@link #sleep Thread.sleep}</li>
 *          *   <li>{@link Object#wait(long) Object.wait} with timeout</li>
 *          *   <li>{@link #join(long) Thread.join} with timeout</li>
 *          *   <li>{@link LockSupport#parkNanos LockSupport.parkNanos}</li>
 *          *   <li>{@link LockSupport#parkUntil LockSupport.parkUntil}</li>线程处于定时等待状态。
 *
 * 6，TERMINATED：终止线程的线程状态。线程已完成执行
 *
* @author liangguitao
* @date 2021/6/2 23:20
* @return
* @throws
*/
class TT implements Callable<String>{

    @Override
    public String call() throws Exception {
        return Thread.currentThread().getName();
    }
}
public class ThreadStatusStateTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        TT tt = new TT();
        FutureTask<String> futureTask = new FutureTask<String>(tt);
        Thread thread = new Thread(futureTask);
        thread.setName("测试线程");
        thread.start();
        System.out.println(futureTask.get());
    }
}
