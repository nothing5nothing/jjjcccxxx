import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Code337 {

    public static Map<TreeNode, Integer> indexRob = new HashMap<>();
    public static Map<TreeNode, Integer> indexNoRob = new HashMap<>();

    public static void main(String[] args) {

        TreeNode treeNodeRight3 = new TreeNode(3);
        TreeNode treeNodeRight2 = new TreeNode(2,null,treeNodeRight3);
        TreeNode treeNodeLeft = new TreeNode(1,null ,treeNodeRight2);
        TreeNode treeNodeRight = new TreeNode(3, null, treeNodeRight3);
        TreeNode treeNode =new TreeNode(4, treeNodeLeft, null);
        System.out.println(rob(treeNode));
    }

    public static int rob(TreeNode root) {
        findMoney(root);
        return Math.max(indexNoRob.get(root), indexRob.get(root));
    }

    public static void findMoney (TreeNode root) {
        if (root==null) {
            return ;
        }
        findMoney(root.left);
        findMoney(root.right);
        indexRob.put(root, root.val + Optional.ofNullable(indexNoRob.get(root.left)).orElse(0)
                + Optional.ofNullable(indexNoRob.get(root.right)).orElse(0)) ;
        indexNoRob.put(root, Math.max(Optional.ofNullable(indexRob.get(root.left)).orElse(0),
                Optional.ofNullable(indexNoRob.get(root.left)).orElse(0))+
                Math.max(Optional.ofNullable(indexRob.get(root.right)).orElse(0),
                        Optional.ofNullable(indexNoRob.get(root.right)).orElse(0)));
    }
}
