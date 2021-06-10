package com.gt.project.model.test;



class Ticket extends Thread{

    private static int ticket=100;

//    private static Object object = new Object();
    Class c = Ticket.class;



    @Override
    public void run() {
        while (true){
            synchronized (c){
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
            }

        }
    }
}
public class ThreadTicketTest {
    public static void main(String[] args) {
        Ticket ticket1 = new Ticket();
        Ticket ticket2 = new Ticket();
        Ticket ticket3 = new Ticket();
        ticket1.setName("第一个卖票窗口");
        ticket2.setName("第二个卖票窗口");
        ticket3.setName("第三个卖票窗口");
        ticket1.start();
        ticket2.start();
        ticket3.start();
    }
}
