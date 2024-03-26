public class Code121 {

    /**
     * 寻找i后面比自己最大的数据
     * 暴力超时
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        int len = prices.length;
        int max = 0;

        for (int i=0;i<len;i++) {
            for(int j = i+1;j<len;j++) {
                if(prices[j]>prices[i]) {
                    max = Math.max(max,prices[j] - prices[i]);
                }
            }
        }
        return max;
    }

    public static int maxProfit(int[] prices) {
        int len = prices.length;
        int min = prices[0];
        int max = 0;
        for (int i=1;i<len;i++) {
            if(prices[i] < min) {
                min = prices[i];
            } else {
                max = Math.max (prices[i] - min, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {

        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }

}
