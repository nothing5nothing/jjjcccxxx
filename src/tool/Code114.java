package tool;

public class Code114 {

    /**
     *
     *
     * @param root
     */
    public static void flatten(TreeNode root) {
        root = dfs(root);
        int i = 0;
    }

    public static TreeNode dfs(TreeNode root) {
        if(root == null) {
            return null;
        }

        TreeNode r = dfs(root.right);
        TreeNode l = dfs(root.left);
        if(l != null ) {
            root.right = l;
            while(l.right!=null) {
                l = l.right;
            }
            l.right = r;
        }
        root.left = null;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        TreeNode root6 = new TreeNode(6);
        root1.left = root2;
        root1.right = root5;
        root5.right = root6;
        root2.right = root4;
        root2.left = root3;
        flatten(root1);
        int i = 0;
    }


}
