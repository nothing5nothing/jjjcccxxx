public class Code392 {


    public static boolean isSubsequence(String s, String t) {
        if("".equals(s)){
            return true;
        }

        int i = 0,j = 0;
        boolean b = false;
        while(i<s.length()) {
            while(j<t.length()) {
                if (t.charAt(j) == s.charAt(i)) {
                    b=true;
                    i++;
                    j++;
                    break;
                }
                b=false;
                j++;
            }
            if(j==t.length() && i!=s.length()){
                return false;
            }
            if(!b){
                return b;
            }

        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("acb","ahbgdc" ));
    }

}
