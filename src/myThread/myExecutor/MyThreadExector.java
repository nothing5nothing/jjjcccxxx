package myThread.myExecutor;

import myThread.MyThread;

import java.util.concurrent.*;

public class MyThreadExector extends ThreadPoolExecutor {
    public MyThreadExector(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    protected void beforeExecute(Thread t, Runnable r) {
        System.out.println(((MyThread)r).getName() + "：beforeExecute将要被执行");
    }
    protected void afterExecute(Runnable r, Throwable t) {
        System.out.println(((MyThread)r).getName() + "：afterExecute已经执行完毕");
    }

}
