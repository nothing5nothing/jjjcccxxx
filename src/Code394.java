import java.util.Stack;

public class Code394 {

    /**
     * 0 数字 1 英文 2 [ 3 ]
     * @param s
     * @return
     */
    public  static String decodeString(String s) {
        int len = s.length();
        Stack<Integer> stackNum = new Stack<>();
        Stack<String> stackStr = new Stack<>();
        int i =0 ;
        // 判断是否嵌套
        int index = 0;
        while (i<len) {
            if(s.charAt(i) == '4'){
                int a = 1;
            }
            switch (checkChar(s.charAt(i))) {
                case 0:
                    String num = findNum(i,s);
                    stackNum.push(Integer.parseInt(num));
                    i += num.length();
                    continue;
                case 1:
                    String str = findStr(i, s);
                    int len1 = str.length();
                    // 出栈相加再进栈
                    if(i-1<0 || s.charAt(i-1) == ']') {
                        if (!stackStr.empty()) {
                            str = stackStr.pop() + str;
                        }
                    }
                    i = i + len1;
                    stackStr.push(str);
                    continue;
                case 2:
                    // "[" 后面紧跟数字
                    if(checkChar(s.charAt(i+1)) == 0) {
                        stackStr.push("");
                    }
                    index ++;
                    i = i + 1;
                    continue;
                case 3:
                    // 出str 出数字 组数据 再出str 拼接 再进栈
                    String str3 = stackStr.pop();
                    int num3 = stackNum.pop();
                    if(index>1 ) {
                        String str4= stackStr.pop();
                        stackStr.push(str4 + handlerString(num3,str3));
                    } else {
                        stackStr.push(handlerString(num3,str3));
                    }
                    i = i + 1;
                    index--;
            }
        }
        String str = "";
        while (!stackStr.empty()) {
            str = stackStr.pop() + str;
        }
        return str;
    }


    public static String handlerString(int num, String str) {
        String s = str;
        while(num>1) {
            str += s;
            num --;
        }
        return str;
    }

    /**
     * 0 数字, 1 英文, 2 [,  3 ],
     * @param
     * @return
     */
    public static int checkChar(char c) {
        if ('['== c) {
            return 2;
        }
        if (']'== c) {
            return 3;
        }
        if(c < 'a' || c> 'z') {
            return 0;
        }
        return 1;
    }




    public static String findNum(int index, String s) {
        for (int i = index; i < s.length(); i++) {
            if(checkChar(s.charAt(i)) != 0) {
               return s.substring(index,i);
            }
        }
        return s.substring(index);
    }

    public static String findStr(int index, String s) {
        int len = s.length();
        for (int i= index + 1; i<len;i++) {
            if ('[' == s.charAt(i) || ']' == s.charAt(i)) {
                return s.substring(index, i);
            }
            if(s.charAt(i)<'a' || s.charAt(i) > 'z') {
                return s.substring(index, i);
            }
        }
        return s.substring(index);
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }

}
