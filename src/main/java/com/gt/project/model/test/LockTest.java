package com.gt.project.model.test;

import java.util.concurrent.locks.ReentrantLock;

/**
* @Param  
* @description  解决线程安全问题的方式3：Lock锁-----JDK5.0新增
 *
 *
 * 1,synchronized 和 lock锁的异同
 *  相同点:二者都可以解决线程安全问题
 *  不同点：synchronized机制在执行完相应的同步代码以后，自动的释放同步监视器 Lock需要手动的启动同步（lock（））同时结束时候也要手动的实现unlock
* @author liangguitao
* @date 2021/6/9 22:41
* @return   
* @throws  
*/


class TicketLock implements Runnable{

    private int ticket = 100;

    private ReentrantLock lock = new ReentrantLock();
    synchronized

    @Override
    public void run() {
        while (true){
            try{
                lock.lock();
                if(ticket>0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+":"+ticket);
                    ticket--;
                }else {
                    break;
                }
            }finally {
                lock.unlock();

            }

        }
    }
}
public class LockTest {
    public static void main(String[] args) {
        TicketLock tl = new TicketLock();
        Thread thread1 = new Thread(tl);
        Thread thread2 = new Thread(tl);
        Thread thread3 = new Thread(tl);
        thread1.setName("窗口一");
        thread2.setName("窗口二");
        thread3.setName("窗口三");
        thread1.start();
        thread2.start();
        thread3.start();
    }
    
}
