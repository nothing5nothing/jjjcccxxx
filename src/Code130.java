import java.util.ArrayDeque;
import java.util.Queue;

public class Code130 {

    public static void solve(char[][] board) {
        int[][] r = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int m = board.length;
        int n = board[0].length;
        int[][] index = new int[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                handler(board, index, r, i, j, m, n);
            }
        }

        for (int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j]  == 'O' && index[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void handler(char[][] board, int[][] index, int[][] r, int i, int j, int m, int n) {
        if((i>0 && i<m-1) && (j>0 && j<n-1) ) {
            return;
        }
        if(board[i][j] == 'X' || index[i][j] == 1) {
            return;
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i,j});
        index[i][j] = 1;
        while (!queue.isEmpty()) {
            int[] value = queue.poll();
            for(int[] rr : r) {
                int mm = value[0] + rr[0];
                int nn = value[1] + rr[1];
                if (mm>=0 && mm<m && nn>=0 && nn<n) {
                    if(board[mm][nn] == 'O' && index[mm][nn] == 0) {
                        queue.add(new int[]{mm,nn});
                        index[mm][nn] = 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] c = new char[][]{
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };
        solve(c);
        int a = 1;
    }
}
