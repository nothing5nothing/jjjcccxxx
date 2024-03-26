package myThread.inner;

public class A {

    Sub sub;

    public A() {
        this.sub = new Sub(1);
    }

    public InnerInter get() {
       return sub.get();
    }

     class Sub extends AbstractFather {

        int i;

         public Sub(int i) {
             this.i = i;
         }

         public Inner get() {
            return new Inner();
        }
    }

    public static void main(String[] args) {
        A a = new A();
        InnerInter i = a.get();
        int aa = 1;
    }
}
