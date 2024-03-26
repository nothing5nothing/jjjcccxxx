public class Code72 {
    public static int minDistance(String word1, String word2) {

        int l1 = word1.length();
        int l2 = word2.length();
        if(l1*l2==0) {
            return l1+l2;
        }
        int[][] dp = new int[l1+1][l2+1];
        for(int i=0;i<=l1;i++) {
            dp[i][0] = i;
        }
        for(int i=0;i<=l2;i++) {
            dp[0][i] = i;
        }

        for (int i =1;i<=l1;i++) {
            for (int j=1;j<=l2;j++) {
                dp[i][j] = Math.min(dp[i-1][j]+1, Math.min(dp[i][j-1]+1,
                        word1.charAt(i-1) == word2.charAt(j-1)? dp[i-1][j-1]:dp[i-1][j-1]+1 ));
            }
        }
        return dp[l1][l2];
    }

    public static void main(String[] args) {

        System.out.println(minDistance("horse","ros"));
    }

}
