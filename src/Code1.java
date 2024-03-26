import java.util.Arrays;

public class Code1 {

    public static void main(String[] args) {

        Arrays.stream(twoSum(new int[]{3,2,4}, 6 )).forEach(System.out::println);
    }

    public static int[] twoSum(int[] nums, int target) {

        for (int i=0;i<nums.length;i++) {
            for(int j=i+1 ;j< nums.length;j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return  new int[]{};

    }



}
