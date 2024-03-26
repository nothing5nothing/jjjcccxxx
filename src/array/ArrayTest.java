package array;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

public class ArrayTest {

    public static void arrayTest() {
        List<String> list = new ArrayList<>();
        for(int i =1;i<6;i++) {
            list.add("" + i);
        }
//        for (int i = 0;i<list.size();i++) {
//            if("3".equals(list.get(i))) {
//                list.remove(i);
//                i=i-1;
//                continue;
//            }
//            if("4".equals(list.get(i))) {
//                list.remove(i);
//                continue;
//            }
//        }

        for(String str : list) {
            if("3".equals(str)){
                list.remove(str);
            }
        }
        int i = 0;

    }

    public static void vectorTest() {
        Vector<String> vector = new Vector<>();
        for(int i =1;i<6;i++) {
            vector.add("" + i);
        }
        // 异常 使用modCount控制
        vector.forEach((i)->{
            if("3".equals(i)){
                vector.removeElement(i);
            }
        });



    }

    public static void main(String[] args) {
        arrayTest();
        
    }
}
