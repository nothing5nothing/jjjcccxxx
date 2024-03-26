import java.util.ArrayList;
import java.util.List;

public class Code54 {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] v = new int[m+2][n+2];
        for(int i = 0;i<m+2;i++) {
            for(int j =0;j<n+2;j++) {
                if(i == 0 || j == 0 || i==m+1 || j==n+1){
                    v[i][j] = 1;
                }
            }
        }
        int count = 1;
        int routeIndex = 0;
        int[][] route = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        int i=0;
        int j=0;
        v[1][1] =1;
        list.add(matrix[0][0]);
        while(count < m*n) {
            int ii = route[routeIndex][0]+i;
            int jj = route[routeIndex][1]+j;
            if (v[ii+1][jj+1] ==1) {
                routeIndex = (routeIndex+1)%4;
                continue;
            } else {
                i =ii;
                j=jj;
                list.add(matrix[i][j]);
                v[i+1][j+1] = 1;
            }
            count++;
        }
        return list;
    }

    public static void main(String[] args) {
        spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}).forEach(x->System.out.print( " " + x + " " ));
    }
}
