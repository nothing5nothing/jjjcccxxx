import java.util.ArrayList;
import java.util.List;

public class Code46 {


    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        dfs(nums, new ArrayList<>(), list, temp);
        return list;
    }

    public static void dfs(int[] nums, List<Integer> index, List<List<Integer>> list, List<Integer> temp) {
        if(index.size() > nums.length) {
            return;
        }

        if(index.size() == nums.length) {
            list.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0;i<nums.length;i++) {
            if(index.contains(i)) {
                continue;
            }
            index.add(i);
            temp.add(nums[i]);
            dfs(nums, index, list, temp);
            if(index.contains(i)) index.remove(index.size()-1);
            if(temp.contains(nums[i])) temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = permute(new int[]{0,1});

        int a = 1;
    }


}
