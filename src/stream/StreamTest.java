package stream;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};

        long count = Stream.iterate(BigInteger.ONE, t-> t.add(BigInteger.ONE)).limit(100).count();
        System.out.println(count);
    }


}
