public class Code746 {

    public  static  int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len+1];
        dp[0] = 0;
        for (int i = 1; i <= len;i++) {
            if(i == 1) {
                dp[1] = 0;
                continue;
            }
            dp[i] = Math.min(dp[i-1]+cost[i-1], dp[i-2] + cost[i-2]);
        }
        return dp[len];
    }


    public static void main(String[] args) {
        System.out.println( minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}) );
    }

}
