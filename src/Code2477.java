import java.util.ArrayList;
import java.util.List;

public class Code2477 {


    public static void main(String[] args) {
        System.out.println(minimumFuelCost(new int[][]{{3,1},{3,2},{1,0},{0,4},{0,5},{4,6}}, 2));

    }

    public static long minimumFuelCost(int[][] roads, int seats) {
        int value= roads.length;
        // 创建链表 初始化 赋值
        List<Integer>[] lists = new List[value+1];
        for (int i =0 ;i <= value; i++) {
            lists[i] = new ArrayList<>();
        }
        for(int[] i : roads) {
            lists[i[0]].add(i[1]);
            lists[i[1]].add(i[0]);
        }
        dfs(lists,0,-1,seats);
        return ori;

    }

    public static int ori = 0;

    public static int dfs(List<Integer>[] list, int cur, int father, int seat) {
        int pSum = 1;
        for(Integer i : list[cur]) {
            // 排除父节点
            if(father != i) {
                int pCount = dfs(list, i, cur, seat);
                ori += (pCount + seat -1)/seat;
                pSum += pCount;
            }
        }
        return pSum;
    }
}
