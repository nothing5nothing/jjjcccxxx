import java.util.*;

public class Code139 {

    public static boolean wordBreak(String s, List<String> wordDict) {
        Map<String,Integer> map = new HashMap<>();
        int len = s.length();
        for(int i = 0;i<wordDict.size();i++) {
            map.put(wordDict.get(i),1);
        }
        int[] dp = new int[len+1];
        dp[0] =1;
        for(int i = 1;i<len+1;i++) {
            for(int j=0;j<i;j++){
                if(dp[j] == 1 && map.containsKey(s.substring(j,i))){
                    dp[i] =1;
                    break;
                }
            }
        }
        return dp[len] == 1;
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", Arrays.asList("leet","code")));
    }
}
