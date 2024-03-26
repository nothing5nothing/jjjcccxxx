import tool.TreeNode;

public class Code530 {

    public static int getMinimumDifference(TreeNode root) {
        return dfs(root);
    }

    public static int dfs(TreeNode node) {
        if(node == null) {
            return Integer.MAX_VALUE;
        }
        int l = dfs(node.left);
        int r = dfs(node.right);
        int nMin =  Math.min(leftDiff(node), rightDiff(node));
        return Math.min(nMin, Math.min(l,r));
    }



    public static int leftDiff(TreeNode treeNode) {
        TreeNode l = treeNode.left;
        if (l == null) {
            return Integer.MAX_VALUE;
        }
        while(l.right!=null) {
            l = l.right;
        }
        return Math.abs(treeNode.val - l.val);

    }

    public static int rightDiff(TreeNode treeNode) {
        TreeNode l = treeNode.right;
        if (l == null) {
            return Integer.MAX_VALUE;
        }
        while(l.left!=null) {
            l = l.left;
        }
        return  Math.abs(l.val - treeNode.val);
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(14);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(8);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        System.out.println(getMinimumDifference(node1));

    }
}
