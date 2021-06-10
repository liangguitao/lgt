package com.gt.project.model.test;


class SThread extends Thread {
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    private static synchronized void show() {
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":" + ticket);
            ticket--;
        }
    }
}


public class SyncThread {
    public static void main(String[] args) {
        SThread sThread1 = new SThread();
        SThread sThread2 = new SThread();
        SThread sThread3 = new SThread();
        sThread1.setName("窗口一");
        sThread2.setName("窗口二");
        sThread3.setName("窗口三");
        sThread1.start();
        sThread2.start();
        sThread3.start();
    }


}
