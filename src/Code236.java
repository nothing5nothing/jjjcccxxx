public class Code236 {

    private static TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }
    public static boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return false;

        boolean l = dfs(root.left, p,q);
        boolean r = dfs(root.right, p,q);
        if(l&&r || (root.val == p.val || root.val == q.val ) && (l||r) ) {
            ans = root;
        }
        return  l||r|| root.val == p.val || root.val == q.val;
    }




    public static void main(String[] args) {

    }
}
