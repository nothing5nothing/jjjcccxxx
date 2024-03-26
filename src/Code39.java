import tool.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Code39 {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> reList = new ArrayList<>();
        List<Integer> value = new ArrayList<>();
        dfs(candidates,target,0,reList,value);

        return reList;
    }

    public static void dfs(int[] candidates, int target,int deep, List<List<Integer>> reList, List<Integer> value) {
        if(deep+1 > candidates.length) {
            return;
        }
        if(target == 0) {
            // 创建新的数组去接受，不然回溯会删除元素
            reList.add(new ArrayList<>(value));
            return;
        }
        dfs(candidates,target,deep+1,reList,value);
        int candidate =candidates[deep];
        if(target-candidate >=0) {
            value.add(candidate);
            // deep不加1 因为当前数据还可以再次选择！！
            dfs(candidates,target-candidate, deep, reList, value);
            value.remove(value.size()-1);
        }
    }





    public static void main(String[] args) {
        List<List<Integer>> list = combinationSum(new int[]{2,3,6,7}, 7);
        int a = 0;

    }
}
