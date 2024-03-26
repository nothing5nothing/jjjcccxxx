public class Code44 {

    public static int[] searchRange(int[] nums, int target) {

        int len = nums.length;
        int begin = 0;
        int end = len-1;
        int[] re = new int[]{-1,-1};
        while (begin <= end) {
            int mid = (begin + end) /2;
            if(nums[mid] == target) {
                int l = mid;
                int r = mid;
                while(l>=begin && nums[l] == target){re[0] = l--;}
                while(r<=end && nums[r] == target){re[1] = r++;}
                return re;
            }
            if(nums[mid] > target) {
                end = mid-1;
            } else {
                begin = mid +1;
            }
        }
        return re;
    }

    public static void main(String[] args) {

        int[] arr = searchRange(new int[]{}, 6);
        System.out.println(arr[0]+ " " +arr[1]);
    }
}
