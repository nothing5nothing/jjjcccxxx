public class Code63 {

    public static void main(String[] args) {

        System.out.println(uniquePathsWithObstacles(new int[][]{{0,1,0,0,0},{1,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}}));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] index = new int[m][n];
        for (int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if (i==0 && j==0) {
                    index[i][j] = obstacleGrid[i][j] ==1? 0:1;
                    continue;
                }
                if (obstacleGrid[i][j] == 1) {
                    index[i][j] = 0;
                    continue;
                }

                // 动态规划
                int up = i > 0 ? index[i-1][j] : 0;
                int left = j > 0 ? index[i][j-1] : 0;
                index[i][j] = up + left;
            }
        }
        return index[m-1][n-1];




    }


}
