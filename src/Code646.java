import java.text.CollationKey;
import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Code646 {

    public static int findLongestChain(int[][] pairs) {

        int len = pairs.length;
        int[] dp  = new int[len];

       // Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
       List<int[]> arr = Arrays.stream(pairs).sorted(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        }).collect(Collectors.toList());

        for(int i = 0; i<len;i++) {
            dp[i] = 1;
            for(int j = 0; j<i; j++) {
                if(arr.get(i)[0] > arr.get(j)[1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                } else {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
        }
        return dp[len-1];
    }

    public static void main(String[] args) {
        System.out.println(findLongestChain(new int[][]{
                {1,2},{7,8},{4,5}
        }));
    }
}
