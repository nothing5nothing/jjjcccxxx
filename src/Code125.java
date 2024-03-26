public class Code125 {

    public static boolean isPalindrome(String s) {
        String str = getStr(s);
        int i =0;
        int j = str.length()-1;
        while(i<j){
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static String getStr(String s) {
        String reS = "";
        s = s.toLowerCase();
        for(int i =0;i<s.length();i++) {
            if(s.charAt(i)>= 'a' && s.charAt(i) <= 'z'){
                reS += s.charAt(i);
            }
            if(s.charAt(i)>= '0' && s.charAt(i) <= '9'){
                reS += s.charAt(i);
            }
        }
        return reS;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("acva"));

    }

}
