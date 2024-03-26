import java.util.Arrays;

public class code1512 {
     static int numIdenticalPairs(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int count = 0;
        for(int i = 0;i<len;i++){
            int j = i+1;
            if( j >= len) continue;
            while( nums[j] == nums[i] ){
                j++;
                if( j >= len) break;
            }
            count += (j-1-i+1)*(j-1-i)/2;
            i=j-1;
        }
        return count;
    }


    public static void main(String[] args){
        int[] aa ={2,1,3,2};
        int a = numIdenticalPairs(aa);
        System.out.println(a);
    }






}
