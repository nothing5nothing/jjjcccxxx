public class Code53 {

    /**
     * 超出内存限制
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums) {

        int len = nums.length;
        int[][] dp = new int[len][len];
        int max = nums[0];
        for (int i =0;i<len;i++) {
            dp[i][i] = nums[i];
            max = Math.max(max, dp[i][i]);
            for (int j=i+1;j<len;j++) {
                dp[i][j] = Math.max(dp[i][j-1] + nums[j], nums[j]);
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    /**
     * 超出时间限制
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {

        int len = nums.length;

        int max = nums[0];
        for (int i =0;i<len;i++) {
            int index = nums[i];
            max = Math.max(max, index);
            for (int j=i+1;j<len;j++) {
                index = Math.max(index + nums[j], nums[j]);
                max = Math.max(max, index);
            }
        }
        return max;
    }

    public static int maxSubArray(int[] nums) {

        int len = nums.length;

        int max = nums[0];
        int index = nums[0];
        for (int i =1;i<len;i++) {
            index = Math.max(index + nums[i], nums[i]);
            max = Math.max(max, index);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,-1}));

    }
}
