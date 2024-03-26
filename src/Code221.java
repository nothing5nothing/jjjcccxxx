public class Code221 {




    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        int max = Integer.MIN_VALUE;
        for(int i =0;i<m;i++) {
            for(int j =0;j<n;j++) {
                if(j==0 || i==0) {
                    dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                    max = Math.max(max, dp[i][j]);
                    continue;
                }
                dp[i][j] = matrix[i][j] == '1' ? Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]), dp[i][j-1]) + 1 : 0;
                max = Math.max(max, dp[i][j]);
            }
        }
        return max*max;
    }


    public static void main(String[] args) {
        System.out.println(maximalSquare(new char[][]{}));

    }


}
