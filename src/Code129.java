import tool.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Code129 {


    public static int sumNumbers(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        dfs(root,list,"");
        int sum = 0;
        for(Integer i : list) {
            sum+=i;
        }
        return sum;
    }

    public static void dfs(TreeNode root, List<Integer> list,String str) {
        if(root==null){
            return;
        }
        str = str+root.val;
        if(root.left == null && root.right==null) {
            list.add(Integer.parseInt(str));
            return;
        }
        dfs(root.left, list, str);
        dfs(root.right, list, str);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(4);
        TreeNode root2 = new TreeNode(9);
        TreeNode root3 = new TreeNode(0);
        TreeNode root4 = new TreeNode(5);
        TreeNode root5 = new TreeNode(1);
        root1.left = root2;
        root1.right = root3;
        root2.left = root4;
        root2.right = root5;
        System.out.println(sumNumbers(root1));
    }



}
