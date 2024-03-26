import java.util.ArrayList;
import java.util.List;

public class Code77 {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for(int i = 1;i<=n;i++) {
            dfs(n,k,1,i, list, temp);
        }

        return list;
    }


    public static void dfs(int n, int k, int count, int cur, List<List<Integer>> list, List<Integer> tempL) {

        if (cur > n || count > k) {
            return;
        }
        tempL.add(cur);
        if(count ==k){
            list.add(new ArrayList<>(tempL));
            return;
        }
        for (int i = cur;i<=n;i++) {
            dfs(n, k, count+1, ++cur, list, tempL);
            if(tempL.contains(cur)) tempL.remove(tempL.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = combine(4,2);
        int a = 0;
    }



}
