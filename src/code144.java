import java.util.ArrayList;
import java.util.List;




public class code144 {


    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        preTree(root,res);
        return res;
    }

    public void preTree(TreeNode root,List<Integer> res){
        res.add(root.val);
        if(root.left!=null) preTree(root.left,res);
        if(root.right!=null) preTree(root.right,res);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}