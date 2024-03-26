import tool.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Code106 {

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0;i<inorder.length;i++) {
            map.put(inorder[i], i);
        }
        return dfs(inorder,postorder,0,inorder.length-1,inorder.length-1);
    }

    public static Map<Integer, Integer> map = new HashMap<>();

    public static TreeNode dfs(int[] in, int[] post, int inI, int inJ, int index) {
        if(inI>inJ) {
            return  null;
        }
        if(inI==inJ) {
            return new TreeNode(in[inI]);
        }
        int inIndex = map.get(post[index]);
        TreeNode root = new TreeNode(in[inIndex]);
        root.left = dfs(in,post,inI, inIndex-1,index-(inJ-inIndex)-1);
        root.right = dfs(in,post,inIndex+1, inJ,index-1);

        return root;
    }


    public static void main(String[] args) {
        TreeNode t = buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
        int i = 0;
    }
}
