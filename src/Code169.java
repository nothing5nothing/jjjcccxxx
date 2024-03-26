import java.util.HashMap;
import java.util.Map;

public class Code169 {

    public static int majorityElement(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i : nums) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }
        int max = 0;
        int value = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > max) {
                value = entry.getKey();
                max = entry.getValue();
            }
        }
        return value;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3,2,3}));
    }
}
