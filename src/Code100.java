import tool.TreeNode;

public class Code100 {



    public static boolean isSameTree(TreeNode p, TreeNode q) {
        StringBuilder p1 =new StringBuilder();
        StringBuilder p2 =new StringBuilder();
        StringBuilder p3 =new StringBuilder();
        StringBuilder q1 =new StringBuilder();
        StringBuilder q2 =new StringBuilder();
        StringBuilder q3 =new StringBuilder();
        dfs(p,p1,p2,p3,"");
        dfs(q,q1,q2,q3,"");
        if(p1.toString().equals(q1.toString())&&
        p2.toString().equals(q2.toString()) &&
                p3.toString().equals(q3.toString())) {
            return true;
        }
        return false;

    }


    public static void dfs(TreeNode n, StringBuilder s1, StringBuilder s2,StringBuilder s3, String index) {
        if (n == null) {
           return;
        }
        s1.append(n.val).append(index);
        dfs(n.left, s1,s2,s3, "--");
        s2.append(n.val).append(index);
        dfs(n.right, s1,s2,s3,"==");
        s3.append(n.val).append(index);
    }

    public static void main(String[] args) {
        TreeNode n = new TreeNode(1);
        TreeNode n1 = new TreeNode(1);
        n.left = n1;

        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(1);
        n2.right = n3;

        System.out.println(isSameTree(n,n2));
    }
}
