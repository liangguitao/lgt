package com.gt.project.model.work;

public class ThreadWork {

    public static void main(String[] args) {
        //使用匿名内部类写法 简化
        new Thread(){
            @Override
            public void run() {
                currentThread().setName("第一个线程");
                for (int i = 0; i < 1000; i++) {
                    if(i%2==0){
                        System.out.println(Thread.currentThread().getName()+":"+i);
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                currentThread().setName("第二个线程");
                for (int i = 0; i < 100; i++) {
                    if(i%2!=0){
                        System.out.println(Thread.currentThread().getName()+":"+i);
                    }
                }
            }
        }.start();

    }




}
