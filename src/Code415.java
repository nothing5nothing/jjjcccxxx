public class Code415 {

    public static String addStrings(String num1, String num2) {
        int len1 =num1.length();
        int len2 = num2.length();
        int len = Math.max(len1,len2);
        int count = Math.abs(len1-len2);
        while (count>0){
            if(len1<=len2){
                num1 = "0" + num1;
            }else {
                num2 = "0" + num2;
            }
            count--;
        }

        boolean up =false;
        String str = "";
        for (int i=len-1;i>=0;i--) {
            int value1 =  charToInt(num1.charAt(i));
            int value2 =  charToInt(num2.charAt(i));
            int v  =(value1+ value2)  + (up ? 1 :0);
            int sum = v% 10;
            str = sum + str ;
            if(v >= 10) {
                up = true;
                continue;
            }
            up = false;
        }
        if(up) {
            str = "1" + str ;
        }
        return str;
    }

    public static int charToInt(char c) {
        return Integer.parseInt(String.valueOf(c));
    }

    public static void main(String[] args) {
        System.out.print(addStrings("584", "18"));

    }
}
