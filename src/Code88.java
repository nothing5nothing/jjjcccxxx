import java.util.Arrays;

public class Code88 {


    public  static  void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = m;
        while(j < nums1.length) {
            nums1[j++] = nums2[i++];
        }
        i = 0;
        j = m;
        while( i < nums1.length && j< nums1.length) {
            if(nums1[i]<=nums1[j]){
                i++;
                continue;
            }
            handlerLeft(i,j,nums1);
            j++;
            i++;
        }
    }

    public static void handlerLeft(int i,int j, int[] nums) {
        int temp;
        while(j>i) {
            temp = nums[j];
            nums[j] = nums[j-1];
            nums[j-1] = temp;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,0,0,0,0,0};
        merge(arr, 1, new int[]{1,2,3,5,6}, 5);
        Arrays.stream(arr).forEach(x->{System.out.print(x+" ");});
    }
}
