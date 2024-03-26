package reflact;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Cglib {

    static class ClassA {

        public void testA() {
            System.out.println("testA");
        }
    }

    public static void test() throws Exception{
        ClassA classA  = new ClassA();
        ClassA c = (ClassA)Enhancer.create(ClassA.class,
                (MethodInterceptor)(Object var1, Method var2, Object[] var3, MethodProxy var4)->{
                    System.out.println("before enhanceA");
                    Object o = var2.invoke(classA, var3);
                    System.out.println("after enhanceA");
                    return o;
        });
        c.testA();



    }


    public static void main(String[] args) throws Exception {
        test();
    }



}