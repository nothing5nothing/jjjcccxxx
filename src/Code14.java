import javax.management.StringValueExp;

public class Code14 {

    public static String longestCommonPrefix(String[] strs) {

        if(strs.length == 0) {
            return "";
        }
        String ans = "";
        int index = -1;
        boolean flag = true;
        boolean total = false;
        while(flag) {
            index++;
            for( int i = 0;i<strs.length;i++) {
                String str = strs[i];
                if("".equals(str)) return "";
                if(str.length()<index+1) {
                    flag =false;
                    if(i == 0) {
                        total = true;
                    }
                    break;
                }
                if(i == 0) {
                    ans = ans + strs[0].charAt(index);
                    continue;
                }
                if(str.charAt(index) != ans.charAt(index)){
                    flag=false;
                    break;
                }
            }
        }
        return ans.substring(0,total && index < ans.length() ? index+1 : index);

    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(
                new String[]{
                        "a"
                }
        ));

    }
}
