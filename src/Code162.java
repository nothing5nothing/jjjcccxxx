public class Code162 {


    // 无顺序数组2分
    // 巧妙的2分边界设置，避免了-1和len出无穷小的判断
    public static int findPeakElement(int[] nums) {
       int begin = 0;int end = nums.length-1;
       while(begin<end) {
           // 0123,12的中间mid=1,所以在边界前一次循环内
           // mid=begin,后面的判定条件中 begin==end
           int mid = begin + (end - begin)/2;
           if(nums[mid] < nums[mid+1]) {
               // begin永远<=end，则不会到len上
               begin = mid+1;
           }else {
               // end不设置为mid-1，则永远不会触碰-1
               end = mid;
           }
       }
       return begin;
    }



    public static void main(String[] args) {

        System.out.println(findPeakElement(new int[]{3,2,1}));
    }
}
