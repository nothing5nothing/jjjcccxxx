public class Code62 {

    public static void main(String[] args) {

        System.out.println(uniquePaths(3,7));
    }

    public static int uniquePaths(int m, int n) {
        int[][] index = new int[m][n];
        for (int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if (i == 0 || j==0) {
                    index[i][j] = 1;
                    continue;
                }
                // 动态规划
                index[i][j] = index[i-1][j] + index[i][j-1];
            }
        }
        return index[m-1][n-1];




    }

}
