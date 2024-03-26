public class Code151 {


    /**
     * 2、分割字符串
     * @param s
     * @return
     */
    public static String reverseWords(String s) {

        String[] str = s.split(" ");
        String value = "";

        for(int i = str.length-1;i>=0;i--) {
            if ("".equals(str[i])) {
               continue;
            }
            value = value + str[i] + " ";
        }
        value = value.strip();
        return value;
    }

    public static void main(String[] args) {

        System.out.println(reverseWords("a good   exampl"));
    }
}
