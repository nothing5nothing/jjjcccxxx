import java.util.Stack;

public class Code71 {
    public static   Stack<String> stack = new Stack<>();
    public static String simplifyPath(String path) {
        String[] context = path.split("/");
        String pathRe = "";
        for(String str : context) {
            switch (str){
                case "":
                    break;
                case ".":
                    handlerCurrentDir();
                    break;
                case "..":
                    handlerFatherDir();
                    break;
                case "..." :
                    handlerSpecialDirName(str);
                    break;
                default:
                    handlerDirName(str);
                    break;
            }
        }
        if(stack.empty()) {
            return "/";
        }

        while (!stack.empty()){
            pathRe = "/" + stack.pop() + pathRe;
        }
        return pathRe;
    }

    /**
     * .
     */
    public static void handlerCurrentDir() {
    }

    /**
     * ..
     */
    public static void handlerFatherDir() {
        if(stack.empty()) {
            return;
        }
        stack.pop();
    }

    /**
     * ...
     */
    public static void handlerSpecialDirName(String value) {
        stack.push(value);
    }

    /**
     * ...
     */
    public static void handlerDirName(String value) {
        stack.push(value);
    }

    public static String[] getValue (String path) {
        return path.split("/");
    }


    public static void main(String[] args) {

        String strs = simplifyPath("/../");
        System.out.print(strs);

    }


}
