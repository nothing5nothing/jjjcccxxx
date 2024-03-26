public class Code33 {


    /**
     * 0,1,2,3,4,5,6
     * 4,5,6,7,0,1,2
     * 找到k=4
     *
     *
     * 以 【k，k-1+len】 进行二分
     *
     * 7,8,9,10,4,5,6
     * 4,5,6,7 ,0,1,2
     * 对于 k<mid<len-1  mid = mid
     * 对于 mid> len-1的 mid = mid - len
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int len = nums.length;
        int k =0;
        for (int i=0; i<len-1;i++) {
            if(nums[i+1] < nums[i]) {
                k = i+1;
                break;
            }
        }
        int begin = k;
        int end = k-1+len;
        while(begin <= end) {
            int mid = (begin+end)/2;
            mid = (mid > len-1) ? mid-len : mid;
            if(nums[mid] == target) {
                return mid;
            }
            if (nums[mid]>target) {
               end = (mid >= k) ? mid-1 : mid + len - 1;
            }else{
                begin = (mid >= k) ? mid+1 : mid+1 + len;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        System.out.println(search(new int[]{1}, 0));

    }
}
