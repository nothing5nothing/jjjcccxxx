import java.util.HashMap;
import java.util.Map;

public class Code673 {

    public static int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int[] cnt = new int[len];
        int max = 0;
        int ans = 0;
        for(int i = 0;i<len;i++){
            dp[i] =1;
            cnt[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    if(dp[j]+1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    }else if(dp[j]+1 == dp[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                ans = cnt[i];
            } else if(dp[i] == max) {
                ans += cnt[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findNumberOfLIS(new int[]{2,2,2,2,2}));

    }
}
