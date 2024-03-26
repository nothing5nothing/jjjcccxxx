import tool.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Code98 {

    public static boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        int i=0;
        while(i<list.size()-1){
            if(list.get(i) >= list.get(++i)){
                return false;
            }
        }
        return true;
    }

    public static void dfs(TreeNode root, List<Integer> list){
        if(root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(6);
//        TreeNode node6 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
//        node4.left = node6;
        System.out.println( isValidBST(node1));

    }


}
