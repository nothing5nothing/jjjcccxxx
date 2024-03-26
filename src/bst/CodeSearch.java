package bst;

import tool.TreeNode;

public class CodeSearch {



    public TreeNode searchBST(TreeNode root, int val) {
        return bfs(root, val);
    }

    TreeNode bfs(TreeNode root, int val){
        if (null == root){
            return null;
        }
        if (val == root.val) {
            return root;
        }
        if (val < root.val) {
            return bfs(root.left, val);
        }
        if (val > root.val) {
            return bfs(root.right, val);
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.right = new TreeNode(7);
        root.left = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode value =  new CodeSearch().searchBST(root, 1);
        int o = 0;
    }

}
