package myHeap;

public class MaxHeapUtil {


    /**
     * 堆排序---大顶堆
     * @param arr
     * @return
     */
    public static int[] sort(int[] arr) {
        int size = arr.length;
        // 把元素组成堆
        MaxHeap heap = new MaxHeap(size);
        for(int i :arr) {
            heap.add(i);
        }
        int[] value = new int[size];
        int index = 0;
        // 不停取出最上面元素 直到没有数据
        while(heap.size()>0) {
            value[index++] = heap.pop();
        }
        return value;
    }

    /**
     * 获取前topK个小的元素（用大顶堆存前k个小的元素）
     * @param arr
     * @return
     */
    public static int[] topK(int[] arr, int k){
        MaxHeap heap = new MaxHeap(k);
        // 前k个元素加入大顶堆中
        for (int i = 0;i<k;i++) {
            heap.add(arr[i]);
        }
        // 遍历后面的元素
        // 如果比最小值大则丢弃，如果比最大值小，则剔除最大值，加入该值
        // 不停地剔除最大值最后值保留前K个小的元素
        for(int i = k;i<arr.length;i++) {
            if(arr[i] >= heap.peek()){
                continue;
            }
            heap.pop();
            heap.add(arr[i]);
        }
        int[] value = new int[k];
        int index = 0;
        while(heap.size()>0) {
            value[index++] = heap.pop();
        }
        return value;
    }


    public static int theKMax(int[] arr, int k) {
        MaxHeap heap = new MaxHeap(arr.length);
        // 前k个元素加入大顶堆中
        for (int i = 0;i<arr.length;i++) {
            heap.add(arr[i]);
        }

        while(k-->1) {
            heap.pop();
        }
        return heap.peek();
    }



    public static void main(String[] args) {
        int arr = theKMax(new int[]{4,5,7,3,2,56},3);
        int a= 1;
    }
}
