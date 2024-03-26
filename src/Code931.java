public class Code931 {



    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        int[][] dp = new int[n][n];
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++) {
            for(int j =0;j<n;j++) {
                if(i == 0)  {
                    dp[0][j] = matrix[0][j];
                    continue;
                }
                int a1 = j-1>=0 ? dp[i-1][j-1] : Integer.MAX_VALUE;
                int a2 = j+1<n ? dp[i-1][j+1] : Integer.MAX_VALUE;
                int a3 = dp[i-1][j];
                dp[i][j] = Math.min(Math.min(a1,a2),a3) + matrix[i][j];
            }
        }
        for (int i = 0; i<n; i++) {
            min = Math.min(dp[n-1][i], min);
        }
        return min;
    }


    public static void main(String[] args) {

        System.out.println(minFallingPathSum(new int[][]{{-48}}));

    }
}
