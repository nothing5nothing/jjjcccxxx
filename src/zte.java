import java.util.Stack;

public class zte {



    public static void dealString(String line){
        if ("".equals(line)) {
            System.out.println(0);
        }
        int len = line.length();
        String[] lines = new String[len];
        for(int i =0 ;i< len ; i++) {
            lines[i] = String.valueOf(line.charAt(i));
        }
        int[] dp = new int[len];
        dp[0] = 1;
        int max = 1;
        for (int i = 1 ;i<len;i++) {
            for (int j = i-1; j >= i - dp[i-1]; j--) {
                if (lines[j].equals(lines[i])) {
                    dp[i] = i - j ;
                    max = Math.max(max, dp[i]);
                    break;
                }
                if(j == i - dp[i-1]) {
                    dp[i] = dp[i-1] +1;
                    max = Math.max(max, dp[i]);
                }
            }
        }
        System.out.println(max);


    }

    public static void maxWater(String line){
        if("".equals(line)){
            System.out.println(0);
          //  break;
        }

        String[] str = line.split(",");
        int len = str.length;
        int[] lines = new int[len];
        for(int i=0;i<len;i++){
            lines[i] = Integer.parseInt(str[i]);
        }
        int max = Math.min(lines[0],lines[1]);
        for(int j = 1;j<len;j++){
            for(int i =0;i<j;i++){
                int value = Math.min(lines[i],lines[j])*(j-i);
                max = Math.max(max, value);
            }
        }
        System.out.println(max);

    }

    public final static String CHENG = "*";
    public final static String ADD = "+";
    public final static String CHU = "/";
    public final static String JIAN = "-";
    public final static String FUHAO = "*-+/";
    public static void boLan(String line){
        if("".equals(line)){
            System.out.println(0);
            //  break;
        }

        String[] lines = line.split(",");
        Stack<String> stack = new Stack<>();
        for(String str : lines){
            if(FUHAO.contains(str)){
                int a2 = Integer.parseInt(stack.pop());
                int a1 = Integer.parseInt(stack.pop());
                int value = 0 ;
                switch (str){
                    case CHENG :
                        value = a1*a2;
                        break;
                    case ADD :
                        value = a1+a2;
                        break;
                    case CHU :
                        value = a1/a2;
                        break;
                    case JIAN :
                        value = a1-a2;
                        break;
                }
                stack.push(String.valueOf(value));
            }else{
                stack.push(str);
            }
        }
        System.out.println(stack.pop());
    }


    public static void main(String[] args) {
   //     maxWater("1,8,6,2,5,4,8,3,7");
        boLan("4,13,5,/,+");
    }




}
