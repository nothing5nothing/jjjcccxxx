import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Code20 {


    public static boolean isValid(String s) {
        Map<Character,Character> map = new HashMap(){};
        map.put(']','[');
        map.put('}','{');
        map.put(')','(');

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(isLeft(c)) {
                stack.push(c);
                continue;
            }
            if(stack.isEmpty()) {
                return false;
            }
            char cLeft = stack.pop();
            if(map.get(c) == null ||map.get(c) != cLeft) {
                return false;
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }

    public static boolean isLeft(char c) {
        if(c==']') return false;
        if(c=='}') return false;
        if(c==')') return false;
        return true;
    }

    public static void main(String[] args) {

        System.out.println(isValid("("));

    }
}
