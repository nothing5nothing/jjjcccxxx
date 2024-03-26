import java.util.Arrays;

public class Code1901 {


    public static int[] findPeakGrid(int[][] mat) {

        int begin = 0, end = mat.length-1;
        while(begin < end) {
            int mid = (begin+end)>>>1;
            int j = findMax(mat[mid]);
            if(mat[mid][j] > mat[mid+1][j]) {
                end = mid;
            }else{
                begin = mid+1;
            }
        }
        return new int[]{begin, findMax(mat[begin])};


    }

    public static int findMax(int[] index) {
        int max =0;
        for (int i=0;i<index.length;i++) {
            if(index[i] > index[max]) {
                max = i;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(findPeakGrid(new int[][]{{1, 4}, {3, 2}})));
    }
}
