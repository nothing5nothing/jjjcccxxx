import java.util.*;
import java.util.stream.Collectors;

public class Code57 {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> l = new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            l.add(intervals[i]);
        }
        l.add(newInterval);
        l = l.stream().sorted(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        }).collect(Collectors.toList());


        int len = l.size();

        List<Integer[]> list = new ArrayList<>();
        int i=0;
        while(i<len) {
            int min = l.get(i)[0];
            int max = l.get(i)[1];
            int j = i + 1;
            while (j < len) {
                if (l.get(j)[0] > max) {
                    break;
                }
                if (l.get(j)[0] <= max) {
                    max = Math.max(l.get(j)[1],max);
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

    public static void main(String[] args) {
        int[][] arr = insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8});
        int a = 0;
    }


}
