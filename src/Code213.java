public class Code213 {

    public static int rob(int[] nums) {
        int len = nums.length;
        if(len ==1) {
            return nums[0];
        }
        return Math.max(rob1(nums,len ), noRob1(nums,len ));
    }
    public static int rob1(int[] nums, int len) {
        int[][] index = new int[len][2];
        index[0][0] = nums[0];
        index[0][1] = nums[0];
        index[1][0] =  nums[0];
        index[1][1] = nums[0];
        for (int i=2;i<len;i++) {
            index[i][0] = Math.max(index[i-1][1], index[i-2][1]) + nums[i];
            index[i][1] = Math.max(index[i-1][0], index[i-2][0]);
        }
        return Math.max(index[len-2][0],index[len-2][1]);

    }

    public static int noRob1(int[] nums, int len) {
        int[][] index = new int[len][2];
        //index[0][0] = nums[0];
        index[1][0] = nums[1];
        index[1][1] = 0;
        for (int i=2;i<len;i++) {
            index[i][0] = Math.max(index[i-1][1], index[i-2][1]) + nums[i];
            index[i][1] = Math.max(index[i-1][0], index[i-2][0]);
        }
        return Math.max(index[len-1][0],index[len-1][1]);

    }



    public static void main(String[] args) {

        System.out.println(rob(new int[]{1,2,3}));
    }

}
