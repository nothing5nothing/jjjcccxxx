public class Code66 {
    public static  int[] plusOne(int[] digits) {
        int len = digits.length;
        int[] arr = new int[len];
        int index = 1;
        for(int i = len-1;i>=0;i--) {
            int sum = (digits[i] + index)%10;
            index = (digits[i] + index)/10;
            arr[i] = sum;
        }
        if(index == 1) {
            int[] ans = new int[len + 1];
            ans[0] = 1;
            return ans;
        }
        return arr;

    }

    public static void main(String[] args) {
        int[] a = plusOne(new int[]{1,2,3});
        int b = 1;
    }

}
