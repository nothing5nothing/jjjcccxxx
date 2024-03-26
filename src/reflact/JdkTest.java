package reflact;

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
        A target = (A) Proxy.newProxyInstance(
                testClass.getClass().getClassLoader(), new Class[]{A.class},
                // 使用lambda生成 InvocationHandler
                (proxy, method, arg)->{
                    // 对方法进行增强
                    System.out.println("proxy before");
                    // 调用原始方法
                    Object obj = method.invoke(testClass, arg);
                    System.out.println("proxy after");

                    return obj;
                });

        target.test();
    }

}
