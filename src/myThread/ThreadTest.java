package myThread;

import tool.normal.NormalUtil;

import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.concurrent.locks.*;
import java.util.function.LongBinaryOperator;

public class ThreadTest {

    private AtomicInteger aNum = new AtomicInteger(1);

    public void add() {
        aNum.getAndIncrement();
    }

    private AtomicStampedReference<Integer> count =
            new AtomicStampedReference<>(1,1);

    public boolean addCount (int value) {
        return  count.compareAndSet(count.getReference(),
                value,
                count.getStamp(),
                0);
    }

    /**
     * volatile int count;
     */
    public void atomicFieldTest() {
        A a = new A("1", 1);
        int ans = AtomicIntegerFieldUpdater.newUpdater(A.class, "count").getAndAdd(a,5);
        System.out.println("a = "+ ans + ", A = "+ a);
    }


    public void atomicArrayTest() {
//        AtomicIntegerArray integerArray = new AtomicIntegerArray();



    }


    public void longAccumulatorTest() {
        LongAccumulator longAccumulator = new LongAccumulator(
                new LongBinaryOperator() {
            @Override
            public long applyAsLong(long left, long right) {
                return left+right;
            }
        }, 1);
        longAccumulator.accumulate(2);
        System.out.println(longAccumulator.get());
    }


    ReentrantLock lock = new ReentrantLock();
    public void parkTest() {
        Thread t1 = new Thread(()->{
            System.out.println("t1 in");
            // 会被中断
            LockSupport.park();
            //lock.lock();

            System.out.println("t1 un pack");
        });

//        Thread t2 = new Thread(()->{
//            System.out.println("t2 in");
//            lock.lock();
//            System.out.println("t2 out");
//
//        });

        t1.start();
        LockSupport.unpark(t1);
        NormalUtil.sleep(3000l);
//        t2.start();
//        t2.interrupt();
    }


    public void readAndWriteLockTest() {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock rlock = lock.readLock();
        rlock.lock();
        rlock.unlock();
        if(rlock.tryLock()) {
            rlock.unlock();
        }
        ReentrantReadWriteLock.WriteLock wLock = lock.writeLock();
        wLock.lock();
        wLock.unlock();
        if(wLock.tryLock()) {
            wLock.unlock();
        }
    }


    public void readAndWriteLockTest2() {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        Thread t1 = new Thread(() -> {
            ReentrantReadWriteLock.WriteLock wLock = lock.writeLock();
            if(wLock.tryLock()) {
                System.out.println("wlock lock");
                for(;;){

                }
            }
        });
        Thread t2 = new Thread(()->{
            ReentrantReadWriteLock.ReadLock rlock = lock.readLock();
            System.out.println("rlock try lock");
            rlock.lock();
            System.out.println("rlock lock success");
        });
        t1.start();
        t2.start();
        NormalUtil.sleep(2000L);
        System.out.println("t2 status: " + t2.getState());

    }


    public void conditionTest() {
        Lock lock = new ReentrantLock(false);
        Condition condition = lock.newCondition();
        Thread t1 = new Thread(()->{
            lock.lock();
            System.out.println("condition-await");
            try {
                // await 里面会释放锁
                condition.await();
                System.out.println("single t1 success");

                NormalUtil.sleep(10000L);
                System.out.println("t1 out");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        });
        t1.start();
        NormalUtil.sleep(5000L);
        System.out.println("get lock ");
        lock.lock();
        condition.signal();
        System.out.println("will release lock ");
        lock.unlock();

        NormalUtil.sleep(10000L);
        System.out.println("try get lock ");
        lock.lock();
        System.out.println("get lock ");
        lock.unlock();
    }

    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    private final StampedLock stampedlock = new StampedLock();

    public void stampedLockTest() {

        Thread t1 = new Thread(()-> {
           for(;;) {
               long stamp = stampedlock.writeLock();
               try {
                   num += 1;
               } finally {
                   stampedlock.unlockWrite(stamp);
               }
               NormalUtil.sleep(10L);
           }
        });

        Thread t2 = new Thread(()->{
           for (;;) {
               long stamp = stampedlock.tryOptimisticRead();
               int numValue = num;
               if (!stampedlock.validate(stamp)) {
                  stamp = stampedlock.readLock();
                  try{
                      numValue = num;
                      System.out.println("lock value read num = "+numValue);
                  } finally {
                      stampedlock.unlockRead(stamp);
                  }
               }else {
                   System.out.println("read num = "+numValue);
               }
           }
        });
        t1.start();
        t2.start();
    }

    public void semaphoreTest() {
        // 初始化信号量， 信号量数量， 公平/非公平
        Semaphore semaphore = new Semaphore(2,true);
        try{
            // 一次获取多少信号、
            System.out.println("acquire");
            semaphore.acquire(5);
            System.out.println("acquire end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 释放信号
            System.out.println("release");
            semaphore.release(5);
        }
    }

    public void countDownLatchTest(){
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Thread t1 = new Thread(()->{
            NormalUtil.sleep(5000L);
            countDownLatch.countDown();
        });
        t1.start();
        Thread t2 = new Thread(()->{
            System.out.println("t2 count: " + countDownLatch.getCount());
            try{
                countDownLatch.await();
            } catch (InterruptedException e) {

            }
            System.out.println("t2 out await");
        });
        t2.start();
        Thread t3 = new Thread(()->{
            System.out.println("t3 count: " + countDownLatch.getCount());
            try{
                countDownLatch.await();
            } catch (InterruptedException e) {

            }
            System.out.println("t3 out await");
        });
        t3.start();
    }

    public void delayQueue() {
        DelayQueue<DelayTest> queue = new DelayQueue<DelayTest>();
        DelayTest test = new DelayTest(new Date(124,1,7,18,22));
        DelayTest test2 = new DelayTest(new Date(124,1,7,11,18));
        queue.add(test);
        queue.add(test2);
        try{
            System.out.println("waiting take ");
            DelayTest ans = queue.take();
            System.out.println("take finish, ans= "+ ans);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    class DelayTest implements Delayed {

        private Date dateTime;

        public DelayTest(Date dateTime) {
            this.dateTime = dateTime;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return  unit.convert(dateTime.getTime() - System.currentTimeMillis(),
                    TimeUnit.NANOSECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            return (int)(getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS));
        }

        @Override
        public String toString() {
            return "DelayTest{" +
                    "dateTime=" + dateTime +
                    '}';
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ThreadTest().delayQueue();
    }



}
