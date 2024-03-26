import java.util.Stack;

public class Code150 {

    public static int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        int i  =0 ;
        int len = tokens.length;

        while(i<len) {
            if(isNumber(tokens[i])){
                stack.push(Integer.parseInt(tokens[i]));
                i++;
                continue;
            }
            int i1 = stack.pop(),i2= stack.pop();
            switch( tokens[i]){
                case "+":
                    stack.push( i1+i2);
                    i++;
                    continue;
                case "-":
                    stack.push( i2-i1);
                    i++;
                    continue;
                case "*":
                    stack.push( i1*i2);
                    i++;
                    continue;
                case "/":
                    stack.push( i2/i1);
                    i++;
                    continue;
                default:
            }
        }
        return stack.pop();

    }

    private static boolean isNumber(String str) {
        if("+".equals(str)){
            return false;
        }
        if("-".equals(str)){
            return false;
        }
        if("*".equals(str)){
            return false;
        }
        if("/".equals(str)){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
