public class Code5 {


    /**
     * 动态规划
     */
    public static String longestPalindrome(String s) {

        int len = s.length();
        int[][] index = new int[len][len];
        for (int i =0;i<len;i++) {
            index[i][i] = 1;
        }

        int max = 1;
        String maxS = String.valueOf(s.charAt(0));
        for (int j =0 ; j< len;j++) {
            for (int i =0;i< len ;i++) {
                if (i>=j) {
                    continue;
                }
                int subLen = j-i+1;
                if (s.charAt(i) != s.charAt(j)) {
                    continue;
                }
                if (subLen == 2) {
                    index[i][j] =1;
                    if(subLen > max) {
                        max = subLen;
                        maxS = s.substring(i,j+1);
                    }
                    continue;
                }
                index[i][j] = index[i+1][j-1];
                //printInt(index);
                if(index[i][j] ==1 && subLen > max) {
                    max = subLen;
                    maxS = s.substring(i,j+1);
                }
            }
        }
        return maxS;
    }

    public static  void  printInt(int[][] value) {
        for(int i =0 ;i<value.length ;i++){
            for(int j =0 ;j<value.length ;j++){
                System.out.print(value[i][j]+" ");
                if (j == value.length-1) {
                    System.out.println();
                }
            }
        }
    }


    /**
     * 算法思路错的
     * @param s
     * @return
     */
    public static String longestPalindromeWrong(String s) {

        // 反转一个列表
        String reStr = reverse(s);

        // 遍历s判断在反转列表中是否存在
        int max = 1;
        String maxS = String.valueOf( s.charAt(0) );
        int len = s.length();
        for(int i=0;i<len;i++) {
            for(int j = len-1; j>=i; j--) {
                String sub = s.substring(i,j+1);
                if(reStr.contains(sub) && j-i+1 >max){
                    max = j-i+1;
                    maxS = sub;
                }
            }
        }

        return maxS;
    }

    public static String reverse(String s) {
        int j = s.length() -1;
        String str = "";
        while (j>=0) {
            str += s.charAt(j);
            j--;
        }
        return str;
    }


    public static void main(String[] args) {
        // babad  aacabdkacaa
        System.out.print(longestPalindrome("aacabdkacaa"));

    }
}
