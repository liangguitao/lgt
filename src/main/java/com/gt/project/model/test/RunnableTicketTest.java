package com.gt.project.model.test;



/**
* @Param
* @description
 *
 * 例子：创建三个窗口卖票，总票数为100张，使用实现Runnable接口方式
 *
 * 1，存在的线程安全问题:卖票过程中，出现了重票，错票
 *
 * 2，问题出现的原因：当某个线程操作车票的过程中，尚未完成操作时，其他线程参与了进来，也操作这个相同票号的线程。
 *
 * 3，如何解决：当一个线程a在操作车票的时候，其他的线程不能参与进来，知道线程a操作完这个车票时，线程才可以继续操作ticket
 *            即使线程a出现了阻塞，也不能被改变。
 *
 * 4，在java中 ，我们通过同步机制，来解决线程安全问题
 *
 * 方式一：同步代码块
 *         synchronized(同步监视器){
 *           //需要被同步的代码
 *         }
 *      1,说明：操作共享数据的代码，即为需要被同步的代码 --》不能包含多了 也不能包含代码少了
 *      2,共享数据：多个线程共同操作的变量，比如：ticket就是共享数据
 *      3,同步监视器：俗称：锁 任何一个类的对象，都可以充当锁,多个线程要共用一把锁
 *
 *      补充：1，在使用实现Runnable接口的方式创建多线程的方式中，我们可以考虑使用this充当同步监视器
 *           2，在继承thread类创建多线程的方式中，慎用this充当同步监视器  可以使用当前类充当同步监视器。
 *
 *
 *
 *  方式二：同步方法：
 *      如果操作共享数据的代码的完整的声明的在一个方法中，我们不防将这个方法设为同步的
 *      1,同步方法仍然涉及到同步监视器，只是不需要我们显示的声明；
 *      2，非静态的同步方法，同步监视器是：this
 *        静态的同步方法，同步监视器群是:当前类的本身
 *
 *
 *
 *      5，同步的方式：解决了线程安全问题----------好处
 *      操作代码的时，只能有一个线程参与，其他线程等待，相当于是一个单线程的过程。效率低----局限性
 *
 *
* @author liangguitao
* @date 2021/6/3 23:38 
* @return   
* @throws  
*/

class RTicket implements Runnable{
    private int ticket =10000;
    @Override
    public void run() {
        while (true)
        synchronized(this){
                if(ticket>0){
                    System.out.println(Thread.currentThread().getName()+"卖票，票号为："+ticket);
                    ticket--;
                }else {
                    break;
                }
        }
    }
}
public class RunnableTicketTest {
    public static void main(String[] args) {
        RTicket rTicket = new RTicket();
        Thread thread1 = new Thread(rTicket);
        Thread thread2 = new Thread(rTicket);
        Thread thread3 = new Thread(rTicket);
        thread1.setName("第一个窗口");
        thread2.setName("第二个窗口");
        thread3.setName("第三个窗口");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
