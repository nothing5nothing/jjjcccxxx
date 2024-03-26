public class Code191 {

    public static int hammingWeight(int n) {
        int count = 0;
        for(int i = 0;i<32;i++) {
            if((n& (1<<i)) != 0) {
                count++;
            }
        }
        return count;


    }

    public static String cover2(int n) {
        int nn = Math.abs(n);
        String str = "";
        while (nn!=0) {
            str = nn%2 + str;
            nn=nn/2;
        }
        int len = str.length();
        while(len++<32){
            str = "0" + str;
        }
        if(n<0) {
            str ="1"+str.substring(1);
        }
        return str;
    }

    public static void main(String[] args) {

//        System.out.println(hammingWeight(11111111111111111111111111111101));

    }
}
