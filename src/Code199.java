import com.sun.source.tree.Tree;
import tool.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Code199 {

    public static List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            TreeNode node = null;
            while(len > 0) {
                node = queue.poll();
                if(node!=null && node.left!= null) queue.add(node.left);
                if(node!=null && node.right!= null) queue.add(node.right);

                if(len == 1) {
                    list.add(node.val);
                }
                len--;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.right = node5;
//        node3.right = node4;

        List<Integer> list = rightSideView(node1);
        list.stream().forEach(System.out::println);

    }
}
