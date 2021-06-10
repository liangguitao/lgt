package com.gt.project.model.test;
/**
* @Param
* @description
 * 多线程的创建；
 * 1，创建一个继承Thread类的子类
 * 2，重写run方法  ------> 此线程要做的操作声明在这个方法中
 * 3，创建Thread类的子类对象
 * 4，通过此对象调用start（）
 *
 *
 *
 * 例子：遍历100以内的所有偶数
 *
* @author liangguitao
* @date 2021/5/29 18:46
* @return
* @throws
*/


//1，创建一个继承Thread类的子类
class MyThread extends Thread{
    //2，重写run方法  ------> 此线程要做的操作声明在这个方法中
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
public class ThreadTest {
    public static void main(String[] args) {
        //3，创建Thread类的子类对象
        MyThread myThread = new MyThread();

        //4，通过此对象调用start（） :(1)启动当前的线程 （2）调用当前线程run()
        myThread.start();
        for (int i = 0; i < 1000; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i+"##############################################################");
            }
        }

    }
}
