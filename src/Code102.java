import tool.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Code102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            TreeNode node = null;
            List<Integer> tempList = new ArrayList<>();
            while(len-- > 0) {
                node = queue.poll();
                if(node==null) {
                    continue;
                }
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                tempList.add(node.val);
            }
            list.add(tempList);
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
