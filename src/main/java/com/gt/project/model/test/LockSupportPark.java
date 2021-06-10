package com.gt.project.model.test;


import java.util.concurrent.locks.LockSupport;

 class ChangeObjectThread extends Thread {

    @Override public void run() {
            System.out.println("in " + getName());
            LockSupport.park();
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("被中断了");
            }
            System.out.println("继续执行");
        }
}
public class LockSupportPark {

    public static void main(String[] args) {
        ChangeObjectThread changeObjectThread = new ChangeObjectThread();
        LockSupport.unpark(changeObjectThread);
        changeObjectThread.start();

    }
}
