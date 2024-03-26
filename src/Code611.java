import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Code611 {
    public static int triangleNumber(int[] nums) {

        int[] numsSort = Arrays.stream(nums).sorted().toArray();
        int length = nums.length;
        int count = 0;
        for(int a = 0; a < length-2; a++) {
            for(int b = a+1 ;b<length-1; b++) {
                for(int c= b+1; c<length;c++) {
                    if (numsSort[a] + numsSort[b] > numsSort[c]) {
                        count++;
                    }else{
                        break;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        int result = triangleNumber(new int[]{2,2,3,4});
//        System.out.println(result);
        test();

    }

    public static void test() {
        String a ="中", b ="简";
//        a = a^b; x
        long c = 1000L, d = 200L;
        c = c^d;
        d = c^d;
        c = c^d;
        System.out.println(c+"-----" + d);
    }



}
