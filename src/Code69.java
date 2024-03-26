public class Code69 {

    public static int mySqrt(int x) {
        int i = 0;
        if(x== 1){
            return 1;
        }

        while(i<=x/2){
            double l = (double)i*i;
            if(l>x) {
                break;
            }
            i++;
        }
        return i-1;

    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395600));
    }

}
