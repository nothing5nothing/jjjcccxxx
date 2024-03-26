import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {


    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> value = new ArrayList<>();
        // 转换数据
        Map<String,String> map = new HashMap<>();
        for (String str : strs) {
            map.put(str, sortStr(str));
        }

        int indexExist = 0;
        for(String str : strs) {
            for(List<String> list : value) {
                String existValue = map.get(list.get(0));
                if(map.get(str).equals(existValue)) {
                    list.add(str);
                    indexExist =1;
                    break;
                }
            }
            if (indexExist == 1) {
                indexExist = 0;
                continue;
            }
            List<String> lists = new ArrayList<>();
            lists.add(str);
            value.add(lists);
        }



        return value;

    }

    public static String sortStr(String str){
        char[] arr = str.toCharArray();
        quickSort(arr,0 , arr.length-1);
        StringBuffer sb = new StringBuffer();
        for(char c : arr) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void quickSort(char[] arr, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return;
        }

        int left = leftIndex;
        int right = rightIndex;
        //待排序的第一个元素作为基准值
        int key = arr[left];

        //从左右两边交替扫描，直到left = right
        while (left < right) {
            while (right > left && arr[right] >= key) {
                //从右往左扫描，找到第一个比基准值小的元素
                right--;
            }

            //找到这种元素将arr[right]放入arr[left]中
            arr[left] = arr[right];

            while (left < right && arr[left] <= key) {
                //从左往右扫描，找到第一个比基准值大的元素
                left++;
            }

            //找到这种元素将arr[left]放入arr[right]中
            arr[right] = arr[left];
        }
        //基准值归位
        arr[left] = (char)key;
        //对基准值左边的元素进行递归排序
        quickSort(arr, leftIndex, left - 1);
        //对基准值右边的元素进行递归排序。
        quickSort(arr, right + 1, rightIndex);
    }

    public static void main(String[] args) {
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> value = groupAnagrams(str);
        System.out.println("1");
    }
}
