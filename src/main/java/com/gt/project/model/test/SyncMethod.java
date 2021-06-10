package com.gt.project.model.test;


class SMethod implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    public synchronized void show() {
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

public class SyncMethod {
    public static void main(String[] args) {
        SMethod sMethod = new SMethod();
        Thread thread1 = new Thread(sMethod);
        Thread thread2 = new Thread(sMethod);
        Thread thread3 = new Thread(sMethod);
        thread1.setName("窗口一");
        thread2.setName("窗口二");
        thread3.setName("窗口三");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
