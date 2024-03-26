public class Code1006 {


    /**
     * 0 *, 1 /, 2 +, 3 -
     * @param n
     * @return
     */
    public static int clumsy(int n) {
        int [] value = new int[]{1,2,6,7};
        if(n<=4){
            return value[n-1];
        }
        int index = 0;
        int sum = 0;
        long temp = n;
        int count = n;
        while (count-1>0) {
            switch (index) {
                case 0:
                    temp = count * (count-1);
                    if(count<3){
                        sum -=temp;
                    }
                    break;
                case 1:
                    temp = temp/(count-1);
                    if(count == n-1) {
                        sum += temp;
                    }else {
                        sum -=temp;
                    }
                    break;
                case 2:
                    sum += (count-1);
                    break;
                case 3:
                    if(count==2){
                        sum -=(count-1);
                    }
                    break;
                default:
                    break;
            }
            index = (index+1)%4;
            count--;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.print(clumsy(8));
    }
}
