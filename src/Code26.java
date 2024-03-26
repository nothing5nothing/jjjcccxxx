import java.util.*;
import java.util.stream.Collectors;

public class Code26 {

    public static void main(String[] args) {
        int[] nums = new int[]{-3,-1,0,0,0,3,3};
        int size = removeDuplicates(nums);
        System.out.println(size);
        System.out.println(nums.toString());
    }

    public static int removeDuplicates01(int[] nums) {
        // set 会打乱顺序
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int sum = set.size();
        Iterator<Integer> iterator = set.iterator();
        int i=0;
        while (iterator.hasNext() || i<sum) {
            nums[i++] = iterator.next();
        }
        return sum;
    }

    public static int removeDuplicates(int[] nums) {

        if(nums == null || nums.length ==0) {
            return 0;
        }

       int i =0 ;
       int j =1;
       while(j< nums.length) {
           if(nums[i] != nums[j]) {
               nums[++i] = nums[j];
           }
           j++;
       }
       return i+1;
    }

}
