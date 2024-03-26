import java.util.*;

public class code228 {
    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int length = nums.length;
        if (length == 0) {
            return list;
        }
        int i =0;
        while(i<length) {
            int j = i+1;
            String str = ""+ nums[i];
            while (j<length) {
                if(nums[j] - nums[j-1] == 1) {
                    if(j==length-1){
                        str = str + "->" + nums[j];
                    }
                    j++;
                    continue;
                }
                if(j-1!=i) {
                    str = str + "->" + nums[j-1];
                }
                break;
            }
            list.add(str);
            i=j;
        }
        return list;
    }


    public static void main(String[] args) {
        List<String> list = summaryRanges(new int[]{0,2,3,4,6,8,9});
        int a = 1;
    }



}


