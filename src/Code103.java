import tool.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Code103 {


    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> list = new ArrayList<>();
        queue.add(root);

        boolean index = false;
        while(!queue.isEmpty()){
            int len = queue.size();
            List<Integer> listTemp = new ArrayList<>();
            while(len-->0) {
                TreeNode node = queue.poll();
                if(node == null) continue;
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
                listTemp.add(node.val);
            }
            if (index) {
                reverse(listTemp);
            }
            index = !index;
            list.add(listTemp);
        }
        return list;
    }

    public static void reverse (List<Integer> list) {
        int i=0,j = list.size()-1;
        while (i<j) {
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
            i++;
            j--;
        }
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
        List<List<Integer>> list = zigzagLevelOrder(node1);
        int a = 0;
    }
}
