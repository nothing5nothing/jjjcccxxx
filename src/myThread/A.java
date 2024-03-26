package myThread;

public class A {

    private Object object = new Object();

    volatile int count;

    public A() {

    }

    public A(Object object, int count) {
        this.object = object;
        this.count = count;
    }

    public void f11() {
        synchronized(object) {
            try{
                System.out.println("f1 wait in ");
                object.wait();
                System.out.println("f1 wait out ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void f22() {
        synchronized(object) {
            System.out.println("f2 notify in ");
            object.notify();
            System.out.println("f2 notify out ");
        }
    }

    // or
    public synchronized void f1() {
        try{
            System.out.println("f1 wait in ");
            this.wait();
            System.out.println("f1 wait out ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void f2() {
        System.out.println("f2 notify in ");
        this.notify();
        System.out.println("f2 notify out ");
    }









    @Override
    public String toString() {
        return "A{" +
                "object=" + object +
                ", count=" + count +
                '}';
    }

    public static void main(String[] args) {

    }
}
