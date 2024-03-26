public class Code3 {


    /**
     * 滑动窗口
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if("".equals(s)){
            return 0;
        }
        int len = s.length();
        int begin = 0;
        int end = 0;
        int max = 1;

        while(begin<len && end < len) {
            if(begin == end) {
                end++;
                continue;
            }
            String str = s.substring(begin, end);
            if(str.contains(String.valueOf(s.charAt(end)))){
                begin++;
                continue;
            }
            max = Math.max(max,end-begin+1);
            if(end==len-1) {
                begin++;
            }else {
                end++;
            }
        }
        return max;
    }

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
