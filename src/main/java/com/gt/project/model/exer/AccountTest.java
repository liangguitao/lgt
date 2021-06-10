package com.gt.project.model.exer;

import java.util.concurrent.locks.ReentrantLock;

/**
* @Param
* @description   银行有一个账户，
 *   有两储户分别向同一个账户存3000元，每次存1000   存三次  每次存完打印账户余额
 *   分析：
 *   1，是否有多线程问题？ 是  两个储户线程
 *   2，是否有共享数据？ 有  账户  或者账户余额
 *   3，是否存在线程安全问题？  有
 *   4，需要考虑如何解决线程安全问题？ 同步机制： 有三种方式
 *
* @author liangguitao
* @date 2021/6/9 23:20 
* @return   
* @throws  
*/

class Account{

    private double balance;

    private String name;

    public Account(double balance) {
        this.balance = balance;
    }
    //存钱
    public void deposit(double amt){
        if(amt>0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance+=amt;
            System.out.println(Thread.currentThread().getName()+":"+ "存钱成功。余额为："+balance);
        }

    }
}

class Customer extends Thread{

    private Account account;

    private static ReentrantLock lock = new ReentrantLock(true);

    public Customer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                lock.lock();
                account.deposit(1000);
            }finally {
                lock.unlock();
            }
        }
    }
}


public class AccountTest {
    public static void main(String[] args) {
        Account account  = new Account(0);
        Customer customer1 = new Customer(account);
        Customer customer2 = new Customer(account);
        customer1.setName("张三");
        customer2.setName("李四");
        customer1.start();
        customer2.start();
    }
}
