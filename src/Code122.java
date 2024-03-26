public class Code122 {

    public static int maxProfit(int[] prices) {

        int len = prices.length;
        int[][] index = new int[len][2];
        index[0][0] = 0;
        index[0][1] = -prices[0];

        for(int i=1;i<len;i++) {
            index[i][0] = Math.max(index[i-1][1]+prices[i], index[i-1][0]);
            index[i][1] = Math.max(index[i-1][1],index[i-1][0] - prices[i] );
        }
        return index[len-1][0];

    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
