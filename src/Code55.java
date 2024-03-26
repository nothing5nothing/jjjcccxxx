import java.util.ArrayList;
import java.util.List;

public class Code55 {


    public static void main(String[] args) {


        System.out.println(canJump(new int[]{3,2,1,0,4}));
    }


    public static boolean canJump(int[] nums) {
        int len = nums.length;
        boolean[] index = new boolean[len];
        index[0] = true;
        for (int i = 1; i < len; i++) {
            for(int j = 0;j<i; j++) {
                if (nums[j] + j >= i && index[j]) {
                    index[i] = true;
                    break;
                }
            }
        }
        return index[len-1];
    }

    public static boolean canJump01(int[] nums) {
        int len = nums.length;
        int index =0;
        for (int i = 0; i < len; i++) {
            if (index < i) {
                return false;
            }
            index = Math.max(i+nums[i], index);
        }

        return true;
    }

}
