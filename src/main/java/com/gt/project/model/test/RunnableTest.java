package com.gt.project.model.test;



/**
* @Param
* @description   第二种创建线程的方式  implement Runnable接口
 *
 * 1，实现Runnable接口
 * 2，重写run方法
 * 3，创建实现类的对象
 * 4，将这个对象传到Thread类的构造器中，创建Thread对象
 * 5，调用start（）方法，执行run（）
 *
 *
* @author liangguitao
* @date 2021/6/1 22:42
* @return
* @throws
*/
//1，实现Runnable接口
class RTest implements Runnable{
//    2，重写run方法
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
public class RunnableTest {
    public static void main(String[] args) {
//        3，创建实现类的对象
        RTest rTest = new RTest();
//        4，将这个对象传到Thread类的构造器中，创建Thread对象
        Thread thread = new Thread(rTest);
        thread.setName("第二种创建线程的第一个线程");
//       5，调用start（）方法，执行run（）---->调用了Runnable类型的target的run()
        thread.start();
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
