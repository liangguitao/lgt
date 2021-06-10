package com.gt.project.model.test;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

class Ctest implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        return Thread.currentThread().getPriority();
    }
}
public class CallableTest {

    public static void main(String[] args) {
        Thread.currentThread().setName("主线程");
        System.out.println(Thread.currentThread().getName());
        Ctest ctest = new Ctest();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(ctest);
        Thread thread = new Thread(futureTask);
        thread.setName("子线程");
        thread.start();
        try {
            System.out.println(thread.getName()+":"+futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
