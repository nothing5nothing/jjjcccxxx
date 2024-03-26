public class Code289 {

    private static int[][] arr = new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};


    public static void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] b2 = new int[m][n];
        for(int i=0;i<m;i++) {
            for(int j =0;j<n;j++) {
                b2[i][j] = board[i][j];
            }
        }
        for(int i=0;i<m;i++) {
            for(int j =0;j<n;j++) {
                board[i][j] = isAlive(b2,i,j);
            }
        }
    }

    public static int isAlive(int[][] board, int i,int j) {

        int m = board.length;
        int n = board[0].length;
        int count = 0;
        for (int[] a : arr) {
            int ii = i+a[0];
            int jj = j+a[1];
            if(ii<0 || ii>m-1 || jj <0 || jj>n-1) {
                continue;
            }
            if(board[ii][jj] == 1) {
                count++;
            }
        }
        if(board[i][j] == 0 && count ==3) {
            return 1;
        }

        if(board[i][j] == 0) {
            return 0;
        }

        if(count<2) {
            return 0;
        }

        if(count<=3) {
            return 1;
        }

        return 0;
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
        int[][] arr = new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        print(arr);
        gameOfLife(arr);
        print(arr);
    }
}
