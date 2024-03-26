public class Code918 {

    /**
     *
     * @param nums
     * @return
     */
    public static int maxSubarraySumCircular(int[] nums) {
        int len = nums.length;
        int[] leftMax = new int[len];

        int temp = nums[0];
        int ans = nums[0];
        // !! 考虑到0
        int leftSum = nums[0];
        leftMax[0] = nums[0];
        for(int i =1;i<len;i++) {
            // 构成连续
            temp = Math.max(temp + nums[i], nums[i]);
            //ans 在这个循环里记录中间连续最大值
            ans = Math.max(temp, ans);
            // left 记录以0为起点到i的最大和，可能不包含i但是以0起点
            leftSum += nums[i];
            leftMax[i] = Math.max(leftMax[i-1], leftSum);
        }

        int sum = 0;
        for (int i = len-1; i >= 1;i--) {
            sum +=nums[i];
            // ans 在这个连续里记录包含 0 len-1 序列的最大值
            ans = Math.max(sum + leftMax[i-1], ans);
        }
        return ans;
    }

    public static void main(String[] args) {

        System.out.println(maxSubarraySumCircular(new int[]{-2,2,-2,9}));
    }
}
