import javax.swing.*;
import java.util.*;

public class Code1090 {

    public static int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int len = labels.length;
        // map<int,int> map labelIndex ,labeluse 记录标签使用量
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<len;i++){
            map.put(labels[i],0);
        }
        // 对value排序（labels同时要移动）
        sort(values, labels);
        int count =0;
        int sum =0;
        for(int i=0;i<len;i++){
            if(count>=numWanted) {
                break;
            }
            if(map.get(labels[i]) >= useLimit) {
                continue;
            }
            sum += values[i];
            map.put(labels[i], map.get(labels[i])+1);
            count++;
        }
        return sum;
    }

    public static void sort (int[] values, int[] labels)  {
        int len = values.length;
        for(int i =0;i<len-1;i++) {
            int  max = values[i];
            int index = i;
            // 选择排序找到最大值
            for (int j =i+1;j<len;j++) {
                if(values[j] > max) {
                    max = values[j];
                    index = j;
                }
            }
            swap(values, i,index);
            swap(labels,i,index);
        }
    }

    public static void swap (int[] a, int i , int j) {
        int value = a[i];
        a[i] = a[j];
        a[j] = value;
    }


    public static void main(String[] args) {
        System.out.print(
                largestValsFromLabels(new int[]{9,8,8,7,6},
                        new int[]{0,0,0,1,1}, 3,1)
        );
    }
}
