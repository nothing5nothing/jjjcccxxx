public class Code222 {

    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.right);

        return left+right+1;
    }

    public static void main(String[] args) {

    }
}
