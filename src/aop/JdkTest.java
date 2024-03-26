package aop;

import java.lang.reflect.Proxy;

public class JdkTest {

    public interface A{
        void test();
    }
    public static class TestClass implements A {
        @Override
        public void test() {
            System.out.println("test");
        }
    }
    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        A target = (A)Proxy.newProxyInstance(
                testClass.getClass().getClassLoader(), new Class[]{A.class},
                (proxy, method, arg)->{
                    System.out.println("proxy before");
                    Object obj = method.invoke(testClass,arg);
                    System.out.println("proxy after");
                    return obj;
                });

        target.test();
        int i = 0 ;
    }
}
