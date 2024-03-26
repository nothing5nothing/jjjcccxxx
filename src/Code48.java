public class Code48 {

    /**
     * 先对角线替换
     * 再上下行兑换
     *
     * @param matrix
     */
    public static void rotate(int[][] matrix) {

        // 先对角线替换
        rotate1(matrix);
        print(matrix);
        // 再左右行兑换
        rotate2(matrix);
    }

    public static void rotate1(int[][] matrix) {
        int n = matrix.length;
        for(int i =0; i<n; i++){
            for(int j=0;j<n;j++) {
                // 右斜半不要了
                if (j<=i) {
                    continue;
                }
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    public static void rotate2(int[][] matrix) {
        int n = matrix.length;
        for(int j=0;j<n;j++){
            for(int i =0; i<n; i++) {
                if (j>=n/2) {
                    continue;
                }
                int temp = matrix[i][n-1-j];
                matrix[i][n-1-j] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    private static void print(int[][] matrix){
        int n = matrix.length;
        for(int i =0; i<n; i++){
            for(int j=0;j<n;j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {

        int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        print(arr);
        rotate(arr);
        print(arr);

    }


}
