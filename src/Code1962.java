import java.util.Arrays;
import java.util.PriorityQueue;

public class Code1962 {


    // 超时
    public static int minStoneSum(int[] piles, int k) {
        Arrays.sort(piles);
        int max_value = 0;
        while(k>0) {
            max_value = piles[piles.length-1];
            piles[piles.length-1] = max_value%2 !=0? max_value/2+1 :max_value/2;
            swap(piles);
            k--;
        }

        int sum =0;
        for(int a : piles) {
            sum+=a;
        }
        return sum;


    }

    public static int minStoneSum2(int[] piles, int k) {
        int max_value = 0;
        while(k>0) {
            int index = findMaxIndex(piles);
            max_value = piles[index];
            piles[index] = max_value%2 !=0? max_value/2+1 :max_value/2;
            k--;
        }

        int sum =0;
        for(int a : piles) {
            sum+=a;
        }
        return sum;


    }

    public static int minStoneSum3(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> (b - a));
        for (int pile : piles) {
            pq.offer(pile);
        }
        for (int i = 0; i < k; i++) {
            int pile = pq.poll();
            pile -= pile / 2;
            pq.offer(pile);
        }
        int sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
        return sum;
    }


    public static int findMaxIndex(int[] a) {
        int index = 0;
        int max = a[0];
        for(int i = 0;i<a.length;i++) {
            if(a[i] > max) {
                index = i;
                max = a[i];
            }
        }
        return index;
    }

    public static void swap(int[] a) {
        int value = 0;
        for(int i = a.length-1;i>0;i--) {
            int j = i-1;
            if(a[j] <= a[i]) {
               break;
            }
            value = a[j];
            a[j] = a[i];
            a[i] = value;
        }
    }

    public static void main(String[] args) {

        System.out.println(minStoneSum2(new int[]{5,4,9},2));
    }
}
