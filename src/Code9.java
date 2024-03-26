public class Code9 {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        String str = String.valueOf(x);
        int len = str.length();
        int i =0 ;
        int j = len-1;
        while(i<j) {
            if(str.charAt(i++) != str.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {


    }

}
