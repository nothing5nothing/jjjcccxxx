import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Code347 {

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }
        // 小顶堆
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int i = 0;
        for( Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(i < k) {
                queue.add(new int[]{entry.getKey(), entry.getValue()});
                i++;
                continue;
            }
            if (queue.peek()[1] < entry.getValue()) {
                queue.poll();
                queue.add(new int[]{entry.getKey(), entry.getValue()});
            }
            i++;
        }

        int[] arr= new int[queue.size()];
        int index = 0;
        while (!queue.isEmpty()) {
            arr[index++] = queue.poll()[0];
        }

        return arr;
    }


    public static void main(String[] args) {

        int [] arr = topKFrequent(new int[]{1,1,1,2,2,3} ,2 );

        int a =1;
    }
}
