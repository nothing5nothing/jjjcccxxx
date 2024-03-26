package myThread.threadLocal;

import java.util.concurrent.*;

public class ThreadLocalTest {

    public static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void test() {
        threadLocal.set("main-");
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4,10,10L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10));
        for(int i =0;i<1;i++) {
            int finalI = i;
            Thread t = new Thread(()->{
                threadLocal.set("thread-"+ finalI);
                while(true){
                    threadLocal.get();
                    threadLocal.remove();
                }

            },"thread-"+i);
            executor.execute(t);
        }
        executor.submit(()->{

        });
        executor.shutdown();

    }

    public static void testCallable() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4,10,10L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10));

//        Callable<Integer> c = new Callable<Integer>() {
//            @Override
//            public Integer call() throws Exception {
//                return 1/0;
//            }
//        };
        Runnable t = new Runnable() {
            @Override
            public void run() {
                int i = 1;
            }
        };
        Future<Integer> future = executor.submit(t, 1);
        try{
            future.get();
        }catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(4,10,10L, TimeUnit.SECONDS,
//                new ArrayBlockingQueue<>(10));
//        executor.execute(()->{
//
//        });
//
//        executor.prestartCoreThread();
//        executor.shutdownNow();
        testCallable();
    }
}
