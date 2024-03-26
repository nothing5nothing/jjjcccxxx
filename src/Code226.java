import com.sun.source.tree.Tree;
import tool.TreeNode;

public class Code226 {

    public static TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }

        TreeNode l  = invertTree(root.left);
        TreeNode r  = invertTree(root.right);

        root.left  = r;
        root.right = l;
        return root;
    }


    public static void main(String[] args) {

        TreeNode n = new TreeNode(4);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(7);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(9);
        n.left = n1;
        n.right=n2;
        n1.left=n3;
        n1.right=n4;
        n2.left=n5;
        n2.right=n6;
        TreeNode t = invertTree(n);
        int a = 0;
    }
}
