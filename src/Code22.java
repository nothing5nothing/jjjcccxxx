import java.util.ArrayList;
import java.util.List;

public class Code22 {






    public static List<String> generateParenthesis(int n) {

        List<String> list = new ArrayList<>();
        dfs(list, "", 0,0,0,n);
        return list;
    }


    public static void dfs (List<String> list, String str,int left, int right, int count, int n) {

        if(count > n*2) {
            return;
        }
        if(count == n*2) {
            if(list.contains(str)) return;
            list.add(str);
            return;
        }

        int index = 0;
        while (index<2) {
            if(index%2==0 && left<n){
                str = str + "(";
                dfs(list, str, left+1, right, count+1, n);
                str = str.substring(0, str.length()-1);
            } else {
                if(right < left && right<n){
                    str = str + ")";
                    dfs(list, str, left, right+1, count+1, n);
                    str = str.substring(0, str.length()-1);
                }

            }
            index ++ ;
        }


    }

    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
        int a = 1;
    }
}
