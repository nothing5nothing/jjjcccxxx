public class Code153 {


    public static int findMin(int[] nums) {
        int len = nums.length;
        int begin = 0;
        int end = len-1;
        while(begin < end) {
            int min = (begin + end) /2;
            if (nums[min] < nums[end]) {
                //
                end = min;
            } else {
                begin = min+1;
            }
        }
        return nums[begin];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3,4,5,1,2}));
    }
}
