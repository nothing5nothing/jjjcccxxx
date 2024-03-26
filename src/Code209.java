public class Code209 {


    /**
     * 动态滑动窗口
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int index = Integer.MAX_VALUE;
        int sum =nums[0];
        int start = 0;
        int end = 0;

        while(start<nums.length && start<=end) {
            if(sum>=target) {
                index  = Math.min(index, end-start+1);
                sum = sum-nums[start];
                start++;
                continue;
            }

            end++;
            if(end > nums.length-1){
                end = nums.length-1;
                start++;
            } else {
                sum = sum+nums[end];
            }
        }
        if(index == Integer.MAX_VALUE) {
            return 0;
        }
        return index;
    }

    /**
     * 超出内存限制
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen1(int target, int[] nums) {

        int m = nums.length;
        int[][] index = new int[m][m];
        int minIndex = Integer.MAX_VALUE;

        for (int i=0;i<m;i++) {
            for(int j=i;j<m;j++){
                if(j==i) {
                    index[i][j] = nums[i];
                    if (index[i][j] >= target) {
                        return 1;
                    }
                    continue;
                }
                index[i][j] = index[i][j-1] + nums[j];
                if (index[i][j] >= target) {
                   minIndex = Math.min(minIndex, j-i+1);
                }
            }
        }
        if(minIndex == Integer.MAX_VALUE) {
            return 0;
        }
        return minIndex;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
    }
}
