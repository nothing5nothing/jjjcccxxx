package myHeap;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Arrays;

public class QueueHeap {
    public static void main(String[] args) {

        // 创建一个空的最大堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // 创建带初始值的「堆」， 或者称为「堆化」操作，此时的「堆」为「最小堆」
        PriorityQueue<Integer> heapWithValues= new PriorityQueue<>(Arrays.asList(3,1,2));

        // 创建一个最小堆实例
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // 分别往最小堆中添加3，1，2
        minHeap.add(3);
        minHeap.add(1);
        minHeap.add(2);
        // 查看最小堆的所有元素，结果为：[1, 3, 2]
        System.out.println("minHeap: "+minHeap.toString());
        // 获取最小堆的堆顶元素
        int peekNum = minHeap.peek();
        // 结果为：1
        System.out.println("peek number: "+peekNum);
        // 删除最小堆的堆顶元素
        int pollNum = minHeap.poll();
        // 结果为：1
        System.out.println("poll number: "+pollNum);
        // 查看删除1后最小堆的堆顶元素，结果为：2
        System.out.println("peek number: "+minHeap.peek());
        // 查看新的最小堆的所有元素，结果为：[2,3]
        System.out.println("minHeap: "+minHeap.toString());
        // 查看最小堆的元素个数，也是最小堆的长度
        int heapSize = minHeap.size();
        // 结果为：2
        System.out.println("minHeap size: "+heapSize);
        // 判断最小堆是否还有元素
        boolean isEmpty = minHeap.isEmpty();
        // 结果为： false
        System.out.println("isEmpty: "+isEmpty);
    }
}
