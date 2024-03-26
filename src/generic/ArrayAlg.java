package generic;

import java.util.Arrays;
import java.util.function.IntFunction;

public class ArrayAlg {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 运行时错误
    public static  <T extends Comparable> T[] getValue(T... value) {
        var a = new Comparable[2];
        a[0] = value[0];
        return (T[])a;
    }

    // 添加一个构造器
//    public static  <T extends Comparable> T[] getValue(
//            IntFunction<T[]> function, T... value) {
//        var a = function.apply(2 ); // new Comparable[2];
//        a[0] = value[0];
//        return a;
//    }

    public static void main(String[] args) {
        // java.lang.ClassCastException
        String[] value = ArrayAlg.getValue("2","2","4");
//        String[] value = ArrayAlg.getValue(String[]::new,"2","2","4");
    }
}
