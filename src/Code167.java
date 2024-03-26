public class Code167 {

    public static int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int i =0, j=len-1;

        while (i<j) {
            if(numbers[i] + numbers[j] > target) {
                j--;
                continue;
            }
            if(numbers[i] + numbers[j] < target){
                i++;
                continue;
            }
            return new int[]{i+1,j+1};
        }
        return new int[]{i,j};
    }


    public static void main(String[] args) {
        int[] arr = twoSum(new int[]{-1,0}, -1);
        System.out.println(arr[0]+" "+ arr[1]);

    }
}
