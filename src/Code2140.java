public class Code2140 {


    // 状态后效性
    public  static  long mostPoints(int[][] questions) {
        int len = questions.length;
        long[] dp = new long[len+1];
        dp[len] = 0;
        for(int i = len-1;i>=0;i--) {
            dp[i] = Math.max(dp[i+1],
                    dp[Math.min(questions[i][1]+i+1, len)] + questions[i][0]);
        }
        return dp[0];
    }

    // wrong 且 超时
    public  static  long mostPoints1(int[][] questions) {

        int len = questions.length;
        long[] dp = new long[len];
        long max = 0;
        for(int i=0; i<len; i++) {
            dp[i] = questions[i][0];
            for(int j=0; j<i; j++) {
                if(i-j > questions[j][1]) {
                    dp[i] = Math.max(dp[j] + questions[i][0], dp[i]);
                } else {
                    dp[i] = Math.max(dp[j],dp[i]);
                }
            }
            max = Math.max(dp[i],max);
        }
        return max;
    }

    public static void main(String[] args) {

        System.out.println(mostPoints(new int[][]{
                {3,2},{4,3},{4,4},{2,5}
        }));

    }
}
