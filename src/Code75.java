import java.util.Arrays;

public class Code75 {


    public static void sortColors(int[] nums) {
        int len = nums.length;
        for (int i =0;i<len;i++) {
            int small = nums[i];
            int index = i;
            for(int j=i+1;j<len;j++) {
                if (nums[j] < small) {
                    small = nums[j];
                    index = j;
                }
            }
            swap(nums, i, index);
        }
        StringBuilder sb = new StringBuilder();
        for(int i : nums) {
            sb.append(i).append(",");
        }
        sb.deleteCharAt(sb.length()-1);

        System.out.println("["+sb+"]");


    }

    public static void swap(int[] nums,int a,int b) {
        int index = nums[a];
        nums[a] = nums[b];
        nums[b] = index;
    }

    public static void main(String[] args) {

        sortColors(new int[]{0,0,2,0,2,1,1,0});
    }
}
