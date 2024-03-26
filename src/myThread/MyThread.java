package myThread;

import tool.normal.NormalUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread{

    private boolean stopped = false;

    private int theThreadIdd;

    public void setThreadName(int theThreadIdd) {
        this.theThreadIdd = theThreadIdd;
    }

    @Override
    public void run() {
        System.out.println(theThreadIdd);
        NormalUtil.sleep(3000L);
    }

    public void stopped() {
        stopped  =true;
    }

    public static void testSync() {
        String a = "1";
        synchronized (a){
            a="2";
        }
        System.out.println(a);


    }

    public static AtomicInteger value = new AtomicInteger(0);
    public final static Object object = new Object();
    public  static  void textSyncAdd(){


        ThreadPoolExecutor executor = new ThreadPoolExecutor(1000,1000,1L,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(),new ThreadPoolExecutor.CallerRunsPolicy());
        Thread t = new Thread(() -> {
            synchronized (object) {
                value.incrementAndGet();
            }
        });
        for(int i =0;i< 100000;i++) {
            executor.submit(t);
        }



    }

    public  static  void textSyncAdd2() {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(100,1000,1L,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(),new ThreadPoolExecutor.CallerRunsPolicy());

        List<Future<?>> list = new ArrayList<>();
        for(int i =0;i< 100000;i++) {
            list.add(executor.submit(new Thread(() -> {
                value.incrementAndGet();
            })));
        }

        for(Future<?> futrue : list) {
            try{
                futrue.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }





    public static void main(String[] args) throws InterruptedException {
//        A a = new A();
//        Thread t1 = new Thread(() ->{
//            a.f11();
//        });
//        Thread t2 = new Thread(() ->{
//            a.f22();
//        });
//        t1.start();
//        t2.start();
        //testSync();
        textSyncAdd2();
        System.out.println(value);

    }


}
