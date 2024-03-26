public class Code58 {

    public int lengthOfLastWord(String s) {
        if(!s.contains(" ")) {
            return s.length();
        }
        String[] str = s.trim().split(" ");
        return str[str.length-1].length();

    }

    public static void main(String[] args) {

    }
}
