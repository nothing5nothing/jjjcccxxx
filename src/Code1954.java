public class Code1954 {

    public static void main(String[] args) {
        System.out.println(minimumPerimeter(13));
    }

    public static long minimumPerimeter(long neededApples) {
        long left = 0;
        long right = 100000;
        long value = 0;
        while (left <= right) {
            long mid = (left +right)/2;
            // 数学公式
            if (2*mid*(mid+1)*(2*mid+1)>=neededApples) {
                value = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return value*8;
    }

}
