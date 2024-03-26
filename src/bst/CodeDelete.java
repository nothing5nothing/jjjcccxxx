package bst;

import tool.TreeNode;

public class CodeDelete {

    // 中序遍历中找到后继节点，在有右子节点的情况下其后继节点为当前节点的右子节点或右子节点的左子树的最左节点。
    public int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }
    public TreeNode deleteNode(TreeNode root, int key){
        if(root == null) return null;
        if(key < root.val){
            root.left = deleteNode(root.left, key);  // 左子树递归删除
        }else if(key > root.val){
            root.right = deleteNode(root.right, key);  // 右子树递归删除
        }else{
            if(root.left!= null && root.right != null){  // 1、被删除节点有左右两个子节点
                root.val = successor(root);            // 在右子树中找最小的元素填充删除节点
                root.right = deleteNode(root.right,root.val);  // 在删除节点的右子树中删除最小元素
            }else{
                if(root.left == null){  // 有右孩子或无子节点情况
                    root = root.right;  // 2、有右孩子则将右孩子直接替换该要删除的节点，3、若无子节点，则root = null
                }else {                 // 有左孩子的情况
                    root = root.left;   // 4、有左孩子则将左孩子替换该要删除的节点
                }
            }
        }
        return root;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.right = new TreeNode(7);
        root.left = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode value =  new CodeDelete().deleteNode(root, 7);
        int o = 0;
    }



}
