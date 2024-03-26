public class Code74 {

    public static boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;

        for (int i =0;i<m;i++) {
            int len = matrix[i].length;
            if (matrix[i][0]<=target && matrix[i][len-1] >= target) {
                return search(matrix[i], target,0,len );
            }
        }
        return false;
    }

    public  static boolean search(int[] matrix, int target,int start,int end) {
        int mid = (start+end)/2;
        if (matrix[mid] == target) {
            return true;
        }
        if (start>=end) {
            return false;
        }
        if (matrix[mid] > target) {
            return search(matrix,target,0,mid);
        }
        if (matrix[mid] < target) {
            return search(matrix,target,mid+1,end);
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1}},1));
    }
}
