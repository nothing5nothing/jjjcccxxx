import tool.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Code230 {

    public static int ans = 0;

    /**
     * 官方解析
     * @param root
     * @param k
     * @return
     */
    public static int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            --k;
            if (k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }



    public static int kthSmallest1(TreeNode root, int k) {

        dfs(root, k,  new ArrayList<>());

        return ans;

    }

    public static void dfs(TreeNode root, int k, List<Integer> list) {
        if(root==null) return;
        dfs(root.left,k,list);
        list.add(root.val);
        if(list.size() == k) {
            ans = root.val;
        }
        dfs(root.right,k,list);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node6;
        System.out.println(kthSmallest(node1, 6));

    }

}
