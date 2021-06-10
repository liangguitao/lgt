package com.gt.project.model.test;

import java.util.concurrent.locks.LockSupport;

/**
* @Param
* @description
 *
 *
 * 测试Thread类中的方法
 * 1，start() 启动线程  执行run（）
 * 2, run(): 通常需要重写Thread类中的此方法，将创建的线程需要执行的部分声明在此方法中
 * 3，currentThread（）：静态方法，执行返回当前代码的操作
 * 4，getName（）：获取当前线程的名字
 * 5，setName（）：设置当前线程的名字
 * 6，yield（）释放当前CPU执行权
 * 7, 线程a调用线程b的join（），此时线程a就进入阻塞状态吗，直到线程b执行完成后  再接着执行线程a
 *
 * * 1,MIN_PRIORITY = 1;线程拥有的最小优先级
 *  *  NORM_PRIORITY = 5;线程拥有的默认优先级
 *  *  MAX_PRIORITY = 10;线程拥有的最高优先级
 *
 *
 *  比较创建线程的两种方式：
 *  开发中优先选择，实现Runnable接口的方式
 *  原因  1，实现Runnable接口的方式没有类的单继承的局限性
 *       2，实现的方式更适合来处理多个线程有共享数据的情况
 *  联系 ： Thread也是实现了Runnable接口
 *  相同点：都需要重写run（）。将线程要执行的逻辑声明在方法中
 *
 *
 *  线程的通信：wait(),notify(),notifyAll():此三个方法定义在Object类中
 *
 *
 *  补充：线程的分类：用户线程和守护线程
 *  Thread.setDaemon（true）设置为守护线程，也叫后台线程。依赖于用户线程（主线程），兔死狗烹 鸟尽弓藏
 *
* @author liangguitao
* @date 2021/5/30 12:45
* @return
* @throws
*/


class Test1 extends Thread{
    @Override
    public void run() {
        this.setName("第一个线程");
        for (int i = 0; i < 200; i++) {
//            if(i%20==0){
//                System.out.println(this.getName()+":"+i);
//                yield();
//            }
            System.out.println(this.getName()+":"+i);

        }
    }
}

class Test2 extends Thread{
    @Override
    public void run() {
        this.setName("第二个线程");
        for (int i = 0; i < 500; i++) {
            System.out.println(this.getName()+":"+i);
        }
    }
}
public class ThreadMethodTest {

    public static void main(String[] args) {

        Test1 test1 = new Test1();
        
        test1.start();



//        Test2 test2 = new Test2();
//
//        test2.start();

        for (int i = 0; i < 200; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
            if(i==20){
                System.out.println(Thread.currentThread().getName()+":"+i);
                try {
                    test1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
