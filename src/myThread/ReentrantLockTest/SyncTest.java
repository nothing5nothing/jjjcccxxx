package myThread.ReentrantLockTest;

public class SyncTest {

    public synchronized static void test1() {
        System.out.println("1");
        while(true){

        }
    }

    public static void test2() {
        synchronized (new Object()) {
            System.out.println("2");
            while(true){

            }
        }
    }

    public synchronized static void test3() {
        System.out.println("3");
        while(true){

        }
    }

    public static void main(String[] args) {
        new Thread(()->{
            test1();
        }).start();

        new Thread(SyncTest::test2).start();

    }
}
