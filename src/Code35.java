public class Code35 {


    public static  int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int begin = 0;
        int end = len-1;
        while (begin<end) {
            int mid = (begin + end)/2;
            if(nums[mid] == target) {
                return mid;
            }
            if (nums[mid] <target) {
                begin = mid+1;
            } else {
                end = mid-1;
            }
        }
        return nums[begin] >= target ? begin : begin+1;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1}, 1));
    }
}
