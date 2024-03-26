public class Code134 {

    public static int canCompleteCircuit(int[] gas, int[] cost) {

        int len = gas.length;
        int max = 0;
        int sum = 0;
        int index =0;
        for (int i =0; i<len;i++) {
            max += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if(max < 0 ){
                index = i+1;
                max =0;
            }
        }
        if(sum<0) {
            return -1;
        }
        return index;
    }


    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(
                new int[]{1,2,3,4,5},
                new int[]{3,4,5,1,2}));

    }
}
