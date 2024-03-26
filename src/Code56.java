import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Code56 {

    public static int[][] merge(int[][] intervals) {
        sort(intervals);
        int len = intervals.length;

        List<Integer[]> list = new ArrayList<>();
        int i=0;
        while(i<len) {
            int min = intervals[i][0];
            int max = intervals[i][1];
            int j = i + 1;
            while (j < len) {
                if (intervals[j][0] > max) {
                    break;
                }
                if (intervals[j][0] <= max) {
                    max = Math.max(intervals[j][1],max);
                }
                j++;
            }
            list.add(new Integer[]{min, max});
            i = j;
        }

        int [][] re = new int[list.size()][2];
        for(int k = 0;k<list.size();k++) {
            re[k][0] = list.get(k)[0];
            re[k][1] = list.get(k)[1];
        }

        return re;
    }

    public static void sort(int[][] arr) {

        /*
        二维数组排序

            Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });

         */
        int len = arr.length;
        for (int i=0;i<len;i++) {
            int min = arr[i][0];
            int index = i;
            for(int j=i+1;j<len;j++) {
                if (arr[j][0] < min) {
                    min = arr[j][0];
                    index = j;
                }
            }
            int[] temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,4},{4,5}};
        int[][] arr = merge(intervals);
        int a=0;

    }


}
