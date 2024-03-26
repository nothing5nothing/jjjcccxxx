public class Code27 {

    public static int removeElement(int[] nums, int val) {
        int len = nums.length;
        int i=len-1;
        int count = 0;
        while(i>=0) {
            if(nums[i] == val) {
                handlerLeft(i, nums);
                count++;
            }
            i--;
        }
        return len-count;
    }

    public static void handlerLeft(int i, int[] nums) {
        int temp;
        while(i<nums.length-1) {
            temp = nums[i+1];
            nums[i+1] = nums[i];
            nums[i] = temp;
            i++;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,2,3,0,4,2};
        System.out.println(removeElement(arr, 0));
        int a = 1;
    }
}
