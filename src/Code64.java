public class Code64 {

    public static int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        for(int i=0;i<m;i++) {
            for(int j =0;j<n;j++){
                if(i ==0 && j==0) continue;
                if(j==0) {
                    dp[i][j] = dp[i-1][0]+grid[i][j];
                    continue;
                }
                if(i==0) {
                    dp[i][j] = dp[0][j-1]+grid[i][j];
                    continue;
                }
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {

        System.out.println(minPathSum(new int[][]{{1,2,3},{4,5,6}}));
    }

}
