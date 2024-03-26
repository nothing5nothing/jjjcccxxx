import java.util.Arrays;

public class Code740 {

    /**
     * DP
     * 排序  选择 i 则放弃 i-1  i+1
     * @param nums
     * @return
     */
    public static int deleteAndEarn(int[] nums) {

        int len = nums.length;

        int max = 0;
        for(int i = 0;i<len;i++) {
            max = Math.max(nums[i], max);
        }

        int[] arr = new int[max+1];
        for(int i : nums) {
            arr[i] = arr[i] + i;
        }
        int a1 = arr[0];
        int a2 = Math.max(arr[1], a1);
        for(int i =2;i< arr.length;i++) {
            int temp = a2;
            a2 = Math.max(a2, a1+arr[i]);
            a1 = temp;
        }
        return a2;
    }

    public static void main(String[] args) {
        System.out.println(deleteAndEarn(new int[]{2,2,3,3,3,4}));

    }

}
