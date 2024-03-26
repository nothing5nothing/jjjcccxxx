import java.util.Arrays;

public class Code322 {

    public static int coinChange(int[] coins, int amount) {
        if(amount==0) {
            return 0;
        }

        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        for(int coin : coins) {
            if(coin>amount) {
                continue;
            }
            dp[coin] =1;
        }
        for (int i=1;i<amount+1;i++) {
            for(int coin : coins) {
                if(i-coin<0) continue;
                if(dp[i-coin] == Integer.MAX_VALUE) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i-coin]+1);
            }
        }
        if(dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[amount];
    }

    public static void main(String[] args) {

        System.out.println(coinChange(new int[]{1}, 0));
    }

}
