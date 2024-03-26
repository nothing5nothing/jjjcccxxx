public class Code1749 {

    public static void main(String[] args) {

        System.out.println(maxAbsoluteSum(new int[]{-7,-1,0,-2,1,3,8,-2,-6,-1,-10,-6,-6,8,-4,-9,-4,1,4,-9}));
    }

    public static int maxAbsoluteSum(int[] nums) {

        int len = nums.length;
        int[] index = new int[len];
        int[] index1 = new int[len];
        index[0] = nums[0];
        index1[0] = nums[0];
        int maxValue=nums[0],minValue = nums[0];
        for (int i = 1; i<len;i++) {
            index[i] = Math.max(index[i-1]+nums[i], nums[i]);
            index1[i] = Math.min(index1[i-1]+nums[i], nums[i]);
            maxValue = Math.max(index[i], maxValue);
            minValue = Math.min(index1[i], minValue);
        }

        return Math.max(Math.abs(maxValue), Math.abs(minValue));

    }

}
