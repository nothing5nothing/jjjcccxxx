public class Code172 {

    public static int trailingZeroes(int n) {

        int ans = 0;
        for(int i = 5; i<=n; i++) {
            for(int j = i; j%5==0; j = j/5) {
                ans++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {

        System.out.println(trailingZeroes(11));

    }
}
