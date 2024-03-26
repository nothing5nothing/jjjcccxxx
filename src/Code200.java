import java.util.*;

public class Code200 {
    public static int numIslands(char[][] grid) {
        int[][] r = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        Queue<int[]> queue = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;
        int[][] index = new int[m][n];
        int count = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++){
                if(grid[i][j] == '0' || index[i][j]!=0) {
                    continue;
                }
                queue.add(new int[]{i,j});
                index[i][j] = 1;
                while (!queue.isEmpty()) {
                    int[] indexTemp = queue.poll();
                    for(int k=0;k<4;k++) {
                        int mm = indexTemp[0] + r[k][0];
                        int nn = indexTemp[1] + r[k][1];
                        if (mm>=0 && mm<m && nn>=0 && nn<n) {
                           if(grid[mm][nn] != '0' && index[mm][nn]==0) {
                               queue.add(new int[]{mm,nn});
                               index[mm][nn] = 1;
                           }
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println( numIslands (new char[][]{
                {'1','1','0','0','1'},
                {'1','1','0','1','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        }));
    }

}
