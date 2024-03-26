public class Code1137 {



    public static int tribonacci(int n) {
        int len = n;
        if(n<3){
            len = 3;
        }
        int[] dp = new int[len+1];
        dp[0] =0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i =3;i<=n;i++) {
            dp[i] = dp[i-2] + dp[i-3] + dp[i-1];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(tribonacci(0));


    }

}
