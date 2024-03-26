import com.sun.source.tree.Tree;
import tool.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Code105 {


    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder,inorder,0,preorder.length-1,0);
    }

    public static Map<Integer, Integer> map = new HashMap<>();

    public static TreeNode dfs(int[] pre, int[] in, int inI, int inJ, int index) {
        if(inI>inJ) {
            return  null;
        }
        if(inI==inJ) {
            return new TreeNode(in[inI]);
        }
        int inIndex = map.get(pre[index]);
        TreeNode root = new TreeNode(in[inIndex]);
        root.left = dfs(pre,in,inI, inIndex-1,index+1);
        root.right = dfs(pre,in,inIndex+1, inJ,index+(inIndex-inI)+1);

        return root;
    }

    public static void main(String[] args) {

        TreeNode t = buildTree(new int[]{1,2}, new int[]{2,1});
        int i = 0;
    }


}
