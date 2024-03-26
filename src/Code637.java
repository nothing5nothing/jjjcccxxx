import tool.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Code637 {

    public static List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Double> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            TreeNode node = null;
            int count =0;
            double sum = 0.0;
            while(len-- > 0) {
                node = queue.poll();
                if(node==null) {
                    continue;
                }
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                sum+=node.val;
                count++;

            }
            list.add(sum/count);
        }
        return list;
    }

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        List<Double> list = averageOfLevels(node1);
        list.stream().forEach(System.out::println);
    }
}
