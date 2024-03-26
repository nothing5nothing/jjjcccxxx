import java.util.Arrays;

public class Code189 {

    public static void rotate(int[] nums, int k) {


        int len = nums.length;
        k = k%len;
        // 整个数组进行翻转
        reverse(nums, 0, len-1);
        // 前n-k个数 翻转
        reverse(nums, 0, k-1);
        // 后k个数翻转
        reverse(nums, k,len-1);
    }


    public static void reverse(int[] nums, int begin, int end) {
        int temp;
        while (begin < end) {
            temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            begin++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,-100,3,99};
        rotate(nums, 2);
        Arrays.stream(nums).forEach(System.out::print);
    }
}
