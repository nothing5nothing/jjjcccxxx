


public class offer46 {

    public static int translateNum(int num) {

        if (0<=num && num <10) {
            return 1;
        }
        String str = String.valueOf(num);
        int len = str.length();
        String[] nums = new String[len];
        for(int i =0 ;i<len;i++){
            nums[i] = String.valueOf(str.charAt(i));
        }
        int[][] dp = new int[len][3];
        dp[0][1] = 1;

        for(int i =1 ;i<len;i++) {
            int index = check(nums[i-1],nums[i]);
            if(index == 1 && Integer.valueOf(nums[i-1]) != 0) {
                dp[i][0] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2] ;
                dp[i][1] = dp[i-1][0] + dp[i-1][2];
                if(i == 1) {
                    dp[i][1] = 1;
                }
            }else{
                dp[i][2] = dp[i-1][0] + dp[i-1][1]+ dp[i-1][2];
            }
        }
        return dp[len-1][0]+  dp[len-1][2] +  dp[len-1][1];
    }
    public static int check(String a1, String a2){
        int a = Integer.valueOf(a1) * 10 + Integer.valueOf(a2);
        if(0<=a && a<26){
            return 1;
        }
        if(a>25){
            return 0;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(translateNum(102022258));
    }


}
