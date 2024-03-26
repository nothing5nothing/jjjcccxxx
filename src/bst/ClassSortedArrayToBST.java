package bst;

import com.sun.source.tree.Tree;
import tool.TreeNode;

public class ClassSortedArrayToBST {


    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null||nums.length==0){
            return null;
        }
        return  bst(nums, 0, nums.length -1);
    }

    public TreeNode bst(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int middle = start + (end - start)/2;
        TreeNode treeNode = new TreeNode(nums[middle]);
        treeNode.left = bst(nums, start, middle-1);
        treeNode.right = bst(nums, middle+1, end);
        return treeNode;
    }



}
