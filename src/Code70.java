public class Code70 {

    public static int climbStairs(int n) {
        if(n==1){
            return 1;
        }

        int[] index = new int[n+1];
        index[1] = 1;
        index[2] = 2;
        for(int i = 3;i<=n;i++){
            index[i] = index[i-1] + index[i-2];
        }
        return index[n];


    }

    public static void main(String[] args) {
        System.out.println(climbStairs(1));

    }
}
