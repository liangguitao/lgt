package com.gt.project.model.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
* @Param
* @description  第四种创建线程的方式：线程池
 *
* @author liangguitao
* @date 2021/6/2 16:37
* @return
* @throws
*/
public class ThreadPoolTest {

    // 创建一个 Executor，它使用单个工作线程在无界队列中运行。
    // （但是请注意，如果这个单线程在关闭之前由于执行失败而终止，如果需要执行后续任务，一个新线程将取代它。）
    // 保证任务按顺序执行，并且不会超过一个任务处于活动状态在任何给定的时间。与其他等效的 {@code newFixedThreadPool(1)} 不同，
    // 返回的执行程序保证不可重新配置以使用其他线程。 @return 新创建的单线程Executor
    ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

    //    创建一个线程池，根据需要创建新线程，但在可用时将重用先前构造的线程。
    //    这些池通常会提高执行许多短期异步任务的程序的性能。
    //    如果可用，调用 {@code execute} 将重用先前构造的线程。
    //    如果没有可用的现有线程，则会创建一个新线程并将其添加到池中。
    //    60 秒内未使用的线程将被终止并从缓存中删除。
    //    因此，保持空闲足够长时间的池不会消耗任何资源。
    //    请注意，可以使用 {@link ThreadPoolExecutor} 构造函数创建具有相似属性但不同细节（例如，超时参数）的池。
    //    @return 新创建的线程池
    ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();

}
