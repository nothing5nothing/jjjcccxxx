import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code15 {

    /**
     * 1、定义最外层循环
     * 2、在最外才能够循环不变的情况下，
     *    里面做双指针循环 ===> 把双循环变成单循环
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i< len; i++) {
            if(i != 0 && nums[i]==nums[i-1]) {
                continue;
            }
            int target = nums[i];
            int j = i+1;
            int k = len-1;
            while (j < k) {
                if(j != i+1 && nums[j] == nums[j-1]) {
                    j++;
                    continue;
                }
                if(nums[j] + nums[k]+ target > 0) {
                    k--;
                    continue;
                }
                if(nums[j] + nums[k] + target < 0) {
                    j++;
                    continue;
                }
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.add(nums[j]);
                list.add(nums[k]);
                res.add(list);
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> list = threeSum(arr);
        int a =1;
    }

}
