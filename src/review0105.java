import java.util.HashMap;
import java.util.Map;

public class review0105 {

    public static int[] twoSum(int[] nums, int target) {

        int [] re = new int[2];
        Map<Integer,Integer> del = new HashMap<>();

        for (int i=0 ; i< nums.length ; i++) {
            del.put(nums[i],i);
        }
        for (int i = 0 ; i< nums.length ; i++) {
            if (del.containsKey(target-nums[i]) && i != del.get(target-nums[i])) {
                re[0] = i;
                re[1] = del.get(target-nums[i]);
                break;
            }

        }
        return re;

    }


    public static void main(String[] args) {
        int [] a = twoSum(new int[]{3,2,4},6);
        System.out.println(a[0] + "  "+ a[1]);
    }


}
