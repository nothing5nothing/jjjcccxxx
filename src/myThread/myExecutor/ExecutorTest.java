package myThread.myExecutor;

import myThread.MyThread;

import java.util.concurrent.*;

public class ExecutorTest {


    public void executorTest() {
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(
//                //核心线程会一直存活，及时没有任务需要执行
//                //当线程数小于核心线程数时，即使有线程空闲，线程池也会优先创建新线程处理
//                //设置allowCoreThreadTimeout=true（默认false）时，核心线程会超时关闭
//                1,
//                // 在corePoolSize和队列都满的情况下，扩充线程的最大值
//                20,
//                // maximumPoolSize中空闲线程存活最大值 以及时间单位
//                10, TimeUnit.MINUTES,
//                // 线程池队列类型 当核心线程数达到最大时，新任务会放在队列中排队等待执行
//                new ArrayBlockingQueue<>(1000),
//                // 线程创建工厂
//                Executors.defaultThreadFactory(),
//                //两种情况会拒绝处理任务：
//                //  - 当线程数已经达到maxPoolSize，切队列已满，会拒绝新任务
//                //  - 当线程池被调用shutdown()后，会等待线程池里的任务执行完毕，再shutdown。
//                //    如果在调用shutdown()和线程池真正shutdown之间提交任务，会拒绝新任务
//                //线程池会调用rejectedExecutionHandler来处理这个任务。如果没有设置默认是AbortPolicy，会抛出异常
//                //ThreadPoolExecutor类有几个内部实现类来处理这类情况：
//                //  - AbortPolicy 丢弃任务，抛运行时异常
//                //  - CallerRunsPolicy 执行任务
//                //  - DiscardPolicy 忽视，什么都不会发生
//                //  - DiscardOldestPolicy 从队列中踢出最先进入队列（最后一个执行）的任务
//                //实现RejectedExecutionHandler接口，可自定义处理器
//                new ThreadPoolExecutor.DiscardOldestPolicy());


        ThreadPoolExecutor executor = new MyThreadExector(
                1,
                20,
                10, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(1000));
        for(int i =0;i<2;i++) {
            MyThread t = new MyThread();
            t.setThreadName(i);
            executor.execute(t);
            System.out.println("out");

        }
//        executor.shutdown();
//
//        try{
//            boolean loop = true;
//            do{
//                // 阻塞等到等待所有任务完成
//                loop = !executor.awaitTermination(2,TimeUnit.SECONDS);
//            } while (loop);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }

    public void callableTest()  {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "1";
            }
        };
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,10,10,TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100));
        Future<String> value = executor.submit(callable);
        try{
            String str = value.get();
            System.out.println(str);
        } catch (Exception e1){

        }


//        // 将Callable包装成FutureTask
//        FutureTask<String> future = new FutureTask<>(new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                return "1";
//            }
//        });
//        // 启动新线程来执行异步任务
//        new Thread(future).start();
//
//        // 获取异步任务的结果
//        try{
//            String result = future.get();
//            System.out.println(result);
//        } catch (Exception e) {
//
//        }

    }





    public static void main(String[] args) {

        new ExecutorTest().callableTest();
    }
}
