package myHeap;

/**
 * 最大堆
 */
public class MaxHeap {

    // 使用数组创建完全二叉树的结构,再使用二叉树构建一个堆
    int[] maxHeap;
    // heapSize用于数组的大小，因为数组在创建的时候至少需要指明数组的元素个数
    int heapSize;
    // realSize用于记录「堆」的元素个数
    int realSize=0;

    public MaxHeap(int heapSize) {
        this.heapSize = heapSize;
        maxHeap = new int[heapSize+1];
        // 为了便于完全二叉树的管理，数组的第0个索引的元素我们不会使用，请随便设置设置成任何一个值。
        maxHeap[0] = 0;
    }

    /**
     * 添加元素
     */
    public void add(int value) {
        realSize++;
        if (realSize>heapSize) {
            System.out.printf("realSize=%s, heapSize=%s%n",realSize , heapSize);
            return;
        }
        // 将添加的元素添加到数组中
        maxHeap[realSize] = value;
        // 新增元素的索引位置
        int index = realSize;
        // 新增元素的父节点的索引位置 完全二叉树的中序排序
        int fatherIndex = realSize/2;
        // 当添加的元素大于父节点时，需要将父节点的值和新增元素的值交换
        while(maxHeap[index] > maxHeap[fatherIndex] && index>1){
            int temp = maxHeap[index];
            maxHeap[index] = maxHeap[fatherIndex];
            maxHeap[fatherIndex] = temp;
            index = fatherIndex;
            fatherIndex = index/2;
        }
    }

    /**
     * 获取堆顶元素
     */
    public int peek() {
        return maxHeap[1];
    }

    /**
     * 删除堆顶元素
     */
    public int pop() {
        if(realSize < 1) {
            System.out.println("empty");
            return Integer.MIN_VALUE;
        }
        int value = maxHeap[1];
        // 将「堆」中的最后一个元素赋值给堆顶元素
        maxHeap[1] = maxHeap[realSize--];
        int index = 1;
        // 当删除的元素不是孩子节点时
        while(index <= realSize/2){
            int left = index * 2;
            int right = index * 2 + 1;
            // 当删除节点的元素小于 左孩子节点或者右孩子节点，代表该元素的值小，
            // 此时需要将该元素与左、右孩子节点中最大的值进行交换
            // 不需要考虑 index是右子树最后一个父节点的问题 即可能right=realSize+1
            // 因为realSize--，所以该数据取不到，但是index一定等于right
            // 所以只有左子树大于index才会交换，且右子树交换优先 例：（20,5,10,3,1,7,6）
            if(maxHeap[index] < maxHeap[left] || maxHeap[index] < maxHeap[right] ) {
                if ( maxHeap[left] > maxHeap[right]) {
                    swap(maxHeap, index, left);
                    index = left;
                    continue;
                }
                swap(maxHeap, index, right);
                index = right;
            } else {
                break;
            }
        }
        return value;
    }

    public void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    // 返回「堆」的元素个数
    public int size() {
        return realSize;
    }


    public String toString() {
        if (realSize == 0) {
            return "No element!";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (int i = 1; i <= realSize; i++) {
                sb.append(maxHeap[i]);
                sb.append(',');
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(']');
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        // 测试用例
        MaxHeap maxheap = new MaxHeap(8);
        maxheap.add(20);
        maxheap.add(5);
        maxheap.add(10);
        maxheap.add(3);
        maxheap.add(1);
        maxheap.add(6);
        maxheap.add(7);
        // [3,1,2]
        System.out.println(maxheap.toString());
        // 3
        System.out.println(maxheap.peek());
        // 3
        System.out.println(maxheap.pop());

        System.out.println(maxheap.toString());
        maxheap.add(4);
        // Add too mant elements
        maxheap.add(5);
        // [4,1,2]
        System.out.println(maxheap.toString());
    }

}


































