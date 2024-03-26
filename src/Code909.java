import java.util.*;

public class Code909 {


    /**
     * 1、添加 number 转 坐标 ij 的方法
     * 2、使用queue做bfs
     *
     * 超时
     * @param board
     * @return
     */
    public static int snakesAndLadders1(int[][] board) {

        int n = board.length;
        // start 跳跃次数
        Queue<int[]> queue = new LinkedList<>();
        // 使用index 提速很快！！！
        boolean[] visit = new boolean[n * n + 1];
        queue.add(new int[]{1,0});

        while (!queue.isEmpty()) {
            int[] start = queue.poll();
            for(int i =1; i<7;i++) {
                int end = start[0] + i;
                if(end > n*n) {
                    break;
                }
                int[] index = numberToIndex(end, n);
                if(board[index[0]][index[1]] != -1) {
                    end = board[index[0]][index[1]];
                }
                if(end == n*n) {
                    return start[1]+1;
                }
                if(!visit[end]) {
                    visit[end] = true;
                    queue.add(new int[]{end, start[1]+1});
                }
            }
        }
        return -1;
    }

    public static int[] numberToIndex(int number, int n) {
        // 求行数
        int row = (number-1)/n;
        int col ;
        // 偶数行
        if(row%2 == 0){
            col = (number-1)%n;
        } else {
            col = n-1-(number-1)%n;
        }
        return new int[]{ n-1-row,col};
    }

    public static int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] vis = new boolean[n * n + 1];
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{1, 0});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 1; i <= 6; ++i) {
                int nxt = p[0] + i;
                if (nxt > n * n) { // 超出边界
                    break;
                }
                int[] rc = id2rc(nxt, n); // 得到下一步的行列
                if (board[rc[0]][rc[1]] > 0) { // 存在蛇或梯子
                    nxt = board[rc[0]][rc[1]];
                }
                if (nxt == n * n) { // 到达终点
                    return p[1] + 1;
                }
                if (!vis[nxt]) {
                    vis[nxt] = true;
                    queue.offer(new int[]{nxt, p[1] + 1}); // 扩展新状态
                }
            }
        }
        return -1;
    }

    public static int[] id2rc(int id, int n) {
        int r = (id - 1) / n, c = (id - 1) % n;
        if (r % 2 == 1) {
            c = n - 1 - c;
        }
        return new int[]{n - 1 - r, c};
    }





    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        System.out.println(snakesAndLadders(new int[][]{
                {-1,-1,-1,135,-1,-1,-1,-1,-1,185,-1,-1,-1,-1,105,-1},{-1,-1,92,-1,-1,-1,-1,-1,-1,201,-1,118,-1,-1,183,-1},{-1,-1,-1,-1,-1,-1,-1,-1,-1,179,-1,-1,-1,-1,-1,-1},{-1,248,-1,-1,-1,-1,-1,-1,-1,119,-1,-1,-1,-1,-1,192},{-1,-1,104,-1,-1,-1,-1,-1,-1,-1,165,-1,-1,206,104,-1},{145,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,229,-1},{-1,-1,75,140,-1,-1,-1,-1,-1,-1,-1,-1,43,-1,34,-1},{-1,-1,-1,-1,-1,-1,169,-1,-1,-1,-1,-1,-1,188,-1,-1},{-1,-1,-1,-1,-1,-1,92,-1,171,-1,-1,-1,-1,-1,-1,66},{-1,-1,-1,126,-1,-1,68,-1,-1,-1,-1,-1,-1,-1,-1,-1},{-1,109,-1,86,28,228,-1,-1,144,-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,59,-1,-1,-1,-1,-1,51,-1,-1,-1,62,-1},{-1,71,-1,-1,-1,63,-1,-1,-1,-1,-1,-1,212,-1,-1,-1},{-1,-1,-1,-1,174,-1,59,-1,-1,-1,-1,-1,-1,133,-1,-1},{-1,-1,62,-1,5,-1,16,-1,-1,-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,59,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
        }));
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("运行时间：" + duration + "毫秒");
        System.out.println(snakesAndLadders1(new int[][]{
                {-1,-1,-1,135,-1,-1,-1,-1,-1,185,-1,-1,-1,-1,105,-1},{-1,-1,92,-1,-1,-1,-1,-1,-1,201,-1,118,-1,-1,183,-1},{-1,-1,-1,-1,-1,-1,-1,-1,-1,179,-1,-1,-1,-1,-1,-1},{-1,248,-1,-1,-1,-1,-1,-1,-1,119,-1,-1,-1,-1,-1,192},{-1,-1,104,-1,-1,-1,-1,-1,-1,-1,165,-1,-1,206,104,-1},{145,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,229,-1},{-1,-1,75,140,-1,-1,-1,-1,-1,-1,-1,-1,43,-1,34,-1},{-1,-1,-1,-1,-1,-1,169,-1,-1,-1,-1,-1,-1,188,-1,-1},{-1,-1,-1,-1,-1,-1,92,-1,171,-1,-1,-1,-1,-1,-1,66},{-1,-1,-1,126,-1,-1,68,-1,-1,-1,-1,-1,-1,-1,-1,-1},{-1,109,-1,86,28,228,-1,-1,144,-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,59,-1,-1,-1,-1,-1,51,-1,-1,-1,62,-1},{-1,71,-1,-1,-1,63,-1,-1,-1,-1,-1,-1,212,-1,-1,-1},{-1,-1,-1,-1,174,-1,59,-1,-1,-1,-1,-1,-1,133,-1,-1},{-1,-1,62,-1,5,-1,16,-1,-1,-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,59,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
        }));

        long endTime2 = System.currentTimeMillis();
        long duration2 = endTime2 - endTime;
        System.out.println("运行时间：" + duration2 + "毫秒");

    }
}
