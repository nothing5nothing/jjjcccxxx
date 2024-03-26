package aop;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

public class CglibTest {

    public static class TestClassCglib{
        public void test() {
            System.out.println("test");
        }
    }
    public static void main(String[] args) {
        TestClassCglib testClass = new TestClassCglib();
        TestClassCglib testClass1 = (TestClassCglib) Enhancer.create(TestClassCglib.class,
                (MethodInterceptor) (p, method, arg, methodProxy) -> {
                    System.out.println("proxy before...");
                    //不会使用反射
                    //Object result = methodProxy.invoke(testClass, arg);
                    // 另一种调用方法，不需要目标对象实例
                    Object result = methodProxy.invokeSuper(p, args);
                    System.out.println("proxy after...");
                    return result;
                });
        // 调用代理
        testClass1.test();
    }
}
