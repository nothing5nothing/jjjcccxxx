package LC703;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class KthLargest {

    // 小顶堆
    int[] arr;

    int heapLength = 0;

    public KthLargest(int k, int[] nums) {
        arr = new int[k+1];
        int len = Math.max(k, nums.length);
        int[] num = new int[len];
        for(int i=0;i<len;i++) {
            if(i>=nums.length) {
                num[i] = Integer.MIN_VALUE;
                continue;
            }
            num[i] = nums[i];
        }

        // 前K个元素加入小顶堆
        for(int i =0;i<k;i++) {
            if(i>=num.length) {
                return;
            }
            addValue(num[i]);
        }
        // 遍历后面的元素，比第一个大的加入，小的过滤
        for(int i = k;i<num.length;i++) {
            if(num[i] > arr[1]) {
                pop();
                addValue(num[i]);
            }
        }
    }

    public int add(int val) {
        if(val > arr[1]) {
            pop();
            addValue(val);
            return arr[1];
        }
        return arr[1];
    }


    public void addValue(int val) {
        heapLength++;
        arr[heapLength] = val;
        int index = heapLength;
        int fatIndex = index/2;
        while (arr[fatIndex] > arr[index] && fatIndex > 0) {
            swap(arr, fatIndex, index);
            index = fatIndex;
            fatIndex = index / 2;
        }
    }

    public int pop () {
        if(heapLength<=0) {
            return Integer.MIN_VALUE;
        }
        int num = arr[1];
        arr[1] = arr[heapLength];
        heapLength--;
        int index = 1;
        while(index <= heapLength /2){
            int left = index*2;
            int right = index * 2 +1;
            if (arr[left] < arr[index] || arr[right] < arr[index]) {
               if (arr[left] < arr[right]) {
                  swap(arr, left, index);
                  index = left;
                  continue;
               }
                swap(arr, right, index);
                index = right;
            } else {
                break;
            }
        }
        return num;
    }

    public void swap(int[] arr1, int i1, int i2) {
        int temp = arr1[i1];
        arr1[i1] = arr1[i2];
        arr1[i2] = temp;
    }

    public static void main(String[] args) throws FileNotFoundException {
        java.io.File file = new File("H:\\sublime文件\\javaTempFile.java");
        FileReader read = new FileReader(file);

        int[] arr = new int[10000];
        Scanner scanner = new Scanner(file);
        int index = 0;
        while(scanner.hasNext()) {
            arr[index++] = Integer.parseInt(scanner.nextLine());
        }
        KthLargest kthLargest = new KthLargest(9999, arr);
        System.out.println(kthLargest.add(8166));
        System.out.println(kthLargest.add(4));

    }




}
