package bst;

import tool.TreeNode;

public class CodeInsert {

    public  TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) {
            return new TreeNode(val);
        }
        bfs(root,val);
        return  root;

    }


    public void bfs(TreeNode root, int val) {

        if (val <= root.val) {
            if (root.left == null) {
                root.left = new TreeNode(val);

                return;
            }
            bfs(root.left, val);
        }

        if (val > root.val) {
            if (root.right == null) {
                root.right = new TreeNode(val);
                return;
            }
            bfs(root.right, val);
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.right = new TreeNode(7);
        root.left = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode value =  new CodeInsert().insertIntoBST(root, 5);
        int o = 0;
    }



}
