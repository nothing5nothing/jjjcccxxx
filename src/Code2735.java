public class Code2735 {

    public static void main(String[] args) {

        System.out.println(minCost(new int[]{15,150,56,69,214,203}, 42));
    }


    public static long minCost(int[] nums, int x) {

        int len = nums.length;
        int[][] index = new int[len][len];

        for(int i =0; i<len;i++) {
            index[i][0] = nums[i];
            for(int j =1 ;j<len;j++) {
                index[i][j] = Math.min(index[i][j-1], nums[(i+len-j)%len]);
            }
        }
        long sum = 1L<<60;
        for(int j=0;j<len;j++) {
            long value = (long) j * x;
            for(int i =0;i<len;i++) {
                value += index[i][j];
            }
            sum = Math.min(value, sum);
        }
        return sum;
    }


}
