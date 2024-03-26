import java.util.Arrays;

public class Code238 {

    public static int[] productExceptSelf(int[] nums) {

        int len = nums.length;

        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = 1;
        right[len-1] = 1;
        for (int i=1;i<len;i++) {
            left[i] = left[i-1] * nums[i-1];
        }
        for (int i=len-2;i>=0;i--) {
            right[i] = right[i+1] * nums[i+1];
        }

        int[] value = new int[len];
        for (int i=0;i<len;i++) {
            value[i] = left[i] * right[i];
        }
        return value;

    }

    public static void main(String[] args) {
        int[] value = productExceptSelf(new int[]{1,2,3,4}) ;
        Arrays.stream(value).forEach(x->{
            System.out.print(x+" ");
                }
        );
    }
}
