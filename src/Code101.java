import tool.TreeNode;

public class Code101 {

    public boolean isSymmetric(TreeNode root) {

        if(root == null) {
            return true;
        }
        return dfs(root,root);

    }

    public static boolean dfs(TreeNode l, TreeNode r) {
        if(l ==null && r==null) {
            return true;
        }
        if(l ==null || r==null) {
            return false;
        }
        return l.val == r.val && dfs(l.left, r.right) && dfs(r.left, l.right);


    }

    public static void main(String[] args) {

    }
}
