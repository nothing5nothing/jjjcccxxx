package bst;

public class CodeKthLargest {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        int cnt;

        TreeNode(int _val){
            val = _val;
            cnt = 1;
        }
    }

    int K = 0;
    TreeNode root = null;

    TreeNode insert(TreeNode root, int val){
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        int lcnt = root.left == null ? 0 : root.left.cnt;
        int rcnt = root.right == null ? 0 : root.right.cnt;
        root.cnt = lcnt + rcnt + 1;
        return root;
    }

    public CodeKthLargest(int k, int[] nums) {
        K = k;

        for( int i = 0; i < nums.length; ++i){
            root = insert(root, nums[i]);
        }
    }

    public int add(int val) {
        root = insert(root, val);
        return find(root,K);
    }

    int find(TreeNode root, int k){
        int lcnt = root.left == null ? 0 : root.left.cnt;
        int rcnt = root.right == null ? 0 : root.right.cnt;
        if(root.cnt - lcnt == k) return root.val;
        else if(root.cnt - lcnt < k){
            return find(root.left, k - rcnt - 1);
        }else{
            return find(root.right, k);
        }
    }

    public static void main(String[] args) {
        CodeKthLargest code = new CodeKthLargest(1,new int[]{1,2,3});
        System.out.println(code.add(0));
    }












}
