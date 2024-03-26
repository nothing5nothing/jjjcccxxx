import tool.TreeNode;

public class Code112 {

    public  static  boolean hasPathSum(TreeNode root, int targetSum) {

        return dfs(root,targetSum, 0);

    }
    public static boolean dfs(TreeNode root, int targetSum,int sum ) {
        if(root==null) {
            return false;
        }
        if(root.val+sum == targetSum){
            if(root.left==null && root.right==null) {
                return true;
            }
        }
        return dfs(root.left,targetSum,sum+root.val) ||
                dfs(root.right,targetSum,sum+root.val);
    }




    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(-2);
        TreeNode root3 = new TreeNode(-3);
        TreeNode root4 = new TreeNode(1);
        TreeNode root5 = new TreeNode(3);
        TreeNode root6 = new TreeNode(-2);
        TreeNode root7 = new TreeNode(-1);
//        TreeNode root8 = new TreeNode(4);
//        TreeNode root9 = new TreeNode(1);
        root1.left = root2;
        root1.right = root3;
        root3.left = root6;
        root2.right = root5;
        root2.left = root4;
        root4.left = root7;

        System.out.println(hasPathSum(root1, -1));

    }
}
