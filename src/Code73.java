public class Code73 {

    /**
     * 用 i*n+j 数组做index
     * index == 1记录是翻转的，而不时本身存在的
     * index == 0 && m == 1 则是原始就存在的
     * @param matrix
     */
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] index = new int[m][n];

        for (int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(matrix[i][j] ==0) {
                    index[i][j] =1;
                }
            }
        }
        for (int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(matrix[i][j] ==0) {
                    handler(matrix, index,i,j);
                }
            }
        }
    }

    public static void handler(int[][] m, int[][] n, int i,int j) {
        if(n[i][j] == 0) {
            return;
        }
        for(int k=0;k<m.length;k++) {
            if (k == i) {
                continue;
            }
            if(n[k][j] == 1) {
                continue;
            }
            m[k][j] = 0;
        }

        for(int k=0;k<m[0].length;k++) {
            if (k == j) {
                continue;
            }
            if(n[i][k] == 1) {
                continue;
            }
            m[i][k] = 0;
        }
    }

    private static void print(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i =0; i<m; i++){
            for(int j=0;j<n;j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {

        int[][] arr = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        print(arr);
        setZeroes(arr);
        print(arr);

    }

}
