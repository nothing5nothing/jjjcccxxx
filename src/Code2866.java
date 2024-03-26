import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Code2866 {

    public static void main(String[] args) {

        System.out.println(maximumSumOfHeights1(Arrays.asList(5,3,4,1,1)));
    }

    public static long maximumSumOfHeights1(List<Integer> maxHeights) {
        int n = maxHeights.size();
        long res = 0;
        long[] prefix = new long[n];
        long[] suffix = new long[n];
        Deque<Integer> stack1 = new ArrayDeque<Integer>();
        Deque<Integer> stack2 = new ArrayDeque<Integer>();

        for (int i = 0; i < n; i++) {
            while (!stack1.isEmpty() && maxHeights.get(i) < maxHeights.get(stack1.peek())) {
                stack1.pop();
            }
            if (stack1.isEmpty()) {
                prefix[i] = (long) (i + 1) * maxHeights.get(i);
            } else {
                prefix[i] = prefix[stack1.peek()] + (long) (i - stack1.peek()) * maxHeights.get(i);
            }
            stack1.push(i);
        }
        for (int i = n - 1; i >= 0; i--) {
            while (!stack2.isEmpty() && maxHeights.get(i) < maxHeights.get(stack2.peek())) {
                stack2.pop();
            }
            if (stack2.isEmpty()) {
                suffix[i] = (long) (n - i) * maxHeights.get(i);
            } else {
                suffix[i] = suffix[stack2.peek()] + (long) (stack2.peek() - i) * maxHeights.get(i);
            }
            stack2.push(i);
            res = Math.max(res, prefix[i] + suffix[i] - maxHeights.get(i));
        }
        return res;

    }


    // out time
    public static long maximumSumOfHeights(List<Integer> maxHeights) {

        int n =maxHeights.size();
        long maxSum = 0;
        long rightSum = 0;
        long leftSum = 0;
        for (int i =0;i<n;i++) {
            if(i==0) {
                rightSum = getRightSum(maxHeights,0) + maxHeights.get(i);
                leftSum = maxHeights.get(i);
                maxSum = rightSum+leftSum-maxHeights.get(i);
                continue;
            }

            if (maxHeights.get(i) >= maxHeights.get(i-1)) {
                leftSum = leftSum + maxHeights.get(i);
                rightSum = getRightSum(maxHeights,i) + maxHeights.get(i);
            }else {
                rightSum = rightSum - maxHeights.get(i-1);
                leftSum = getleftSum(maxHeights, i) + maxHeights.get(i);
            }
            maxSum = Math.max(maxSum, rightSum+leftSum-maxHeights.get(i));
        }
        return maxSum;
    }

    public static long getRightSum(List<Integer> list, int index) {
        long max = list.get(index);
        long sum = 0;
        for (int i = index +1;i<list.size();i++) {
            sum += Math.min(list.get(i), max);
            max = Math.min(max,list.get(i));
        }
        return sum;
    }
    public static long getleftSum(List<Integer> list, int index) {
        long max = list.get(index);
        long sum = 0;
        for (int i = index -1;i>= 0 ;i--) {
            sum += Math.min(list.get(i), max);
            max = Math.min(max,list.get(i));
        }
        return sum;
    }

}
