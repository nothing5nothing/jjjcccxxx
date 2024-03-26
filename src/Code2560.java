import java.util.Arrays;

public class Code2560 {


    public int minCapability(int[] nums, int k) {
        int lower = Arrays.stream(nums).min().getAsInt();
        int upper = Arrays.stream(nums).max().getAsInt();
        while (lower <= upper) {
            int middle = (lower + upper) / 2;
            int count = 0;
            // visited用来跳过间隔
            boolean visited = false;
            // 跳过间隔的遍历全部比middle小的数据
            for (int x : nums) {
                if (x <= middle && !visited) {
                    count++;
                    visited = true;
                } else {
                    visited = false;
                }
            }
            // 比平均数小的数据太多，则最小化的最大值在这其中
            if (count >= k) {
                upper = middle - 1;
            } else {
                // 说明比middle小的数据不够K个
                lower = middle + 1;
            }
        }
        return lower;
    }

    public static void main(String[] args) {

    }
}
