public class Code11 {


    public static int maxArea(int[] height) {
        int j = height.length-1;
        int i =0 ;
        int max = 0;
        while (i < j) {
            int water = getWater(i,j,height);
            max = Math.max(water,max);
            if(height[i]<= height[j]) {
                i++;
            }else {
                j--;
            }
        }
        return max;
    }

    public static int getWater(int i, int j, int[] height) {
        return (j-i) * Math.min(height[i],height[j]);
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
