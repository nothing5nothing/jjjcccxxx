import java.util.ArrayList;
import java.util.List;

public class Code849 {


    public static int maxDistToClosest(int[] seats) {
        int len = seats.length;

        List<Integer> index = new ArrayList<>();
        for (int i=0; i<len; i++) {
            if(seats[i] == 1) {
                index.add(i);
            }
        }
        int firIndex = index.get(0), secIndex = 0;
        int max = 0;
        if(index.get(0) != 0) {
            max = index.get(0);
        }
        if(index.get(index.size()-1) != len-1) {
            max = Math.max(max, len-1 - index.get(index.size()-1));
        }
        for(int i=1; i<index.size();i++) {
            secIndex=index.get(i);
            max = Math.max((secIndex-firIndex)/2, max);
            firIndex= secIndex;
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(maxDistToClosest(new int[]{0,0,1,0,1,1,0,0,0}));
    }
}
