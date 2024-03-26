public class Code186 {

    public static void reverseWords(char[] s) {

        // 反转整个数组
        reverseWhole(s, 0, s.length-1);

        // 反转每个字符串
        reverseEvery(s);


    }

    public static void reverseEvery(char[] s) {
        int begin = 0;
        int len = s.length;
        while (begin < len-1) {
            for(int end = begin+1;end<len;end++) {
                if(end == len-1) {
                    reverseWhole(s, begin, end);
                    begin = end+1;
                    break;
                }
                if (' '== s[end]) {
                    reverseWhole(s, begin, end-1);
                    begin = end+1;
                    break;
                }
            }
        }
    }


    public static void reverseWhole(char[] s, int begin,int end) {
        while(begin < end) {
            char c = s[begin];
            s[begin] = s[end];
            s[end] = c;
            begin++;
            end--;
        }
    }

    public static void main(String[] args) {

        char[] c = new char[]{'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'} ;
        reverseWords(c);
        for(char i : c) {
            System.out.print(i);
        }

    }
}
