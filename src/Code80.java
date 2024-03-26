public class Code80 {


    public static int removeDuplicates(int[] nums) {

        int i =0 ;
        int j =1 ;
        int len = nums.length;
        int lenIndex = 1;
        while (j<len) {
            if (nums[j] == nums[i]) {
                if (lenIndex>1) {
                    j++;
                    lenIndex++;
                    continue;
                }
                lenIndex++;
                nums[++i] = nums[j++];
                continue;
            }
            nums[++i] = nums[j++];
            lenIndex = 1;
        }
        return i+1;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));

    }
}
