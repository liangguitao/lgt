package com.gt.project.model.test;
/**
* @Param
* @description   线程的优先级
 *
 * 1,MIN_PRIORITY = 1;线程拥有的最小优先级
 *  NORM_PRIORITY = 5;线程拥有的默认优先级
 *  MAX_PRIORITY = 10;线程拥有的最高优先级
 *
 *
 *
 *
* @author liangguitao
* @date 2021/6/1 21:32
* @return
* @throws
*/
public class ThreadPriorityTest {


    static class Test1 extends Thread{
        @Override
        public void run() {
            this.setName("第一个线程");
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+"的优先级为"+"+"+this.getPriority()+"______"+i);
            }
        }
    }


   static class Test2 extends Thread{
        @Override
        public void run() {
            this.setName("第二个线程");
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+"的优先级为"+"+"+this.getPriority()+"______"+i);
            }
        }
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.setDaemon(true);
        test1.start();
        Test2 test2 = new Test2();
        test2.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"的优先级为"+"+"+Thread.currentThread().getPriority()+"______"+i);
        }
    }


}
