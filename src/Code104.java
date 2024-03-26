import tool.TreeNode;

public class Code104 {

    public  static int maxDepth(TreeNode root) {

        if(root==null) {
            return 0;
        }
        return dfs(root,1,1);

    }

    public static int dfs(TreeNode n, int deep,int max) {
        if(n==null) {
            return max;
        }
        max = dfs(n.left, deep+1,max);
        max = Math.max(deep, max);
        max = dfs(n.right, deep+1,max);
        max = Math.max(deep, max);
        return max;
    }


    public static void main(String[] args) {
        TreeNode n = new TreeNode(3);
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(7);
        n.left = n1;
        n.right = n2;
        n2.left = n3;
        n2.left = n4;
        System.out.println(maxDepth(n));
    }
}
