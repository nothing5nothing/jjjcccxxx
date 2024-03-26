package lambda;

import generic.ArrayAlg;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaTest {

    public static void main(String[] args) {

        Predicate<String> predicate = s->s.startsWith("1");
        Predicate<String> and = predicate.and(s->s.endsWith("1"));
        System.out.println(and.test("112"));

    }


    //参数为断言型接口
    public static List<String> filterNames(Predicate<String> predicate, List<String> list){
        List<String> resultList=new ArrayList<String>();
        for (String string : list) {
            if(predicate.test(string)) {
                resultList.add(string);
            }
        }
        return resultList;
    }
}
