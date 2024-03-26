import com.sun.source.tree.Tree;

public class Code108 {



    public static TreeNode sortedArrayToBST(int[] nums) {
        int begin = 0;
        int end = nums.length;
        return handler(nums,begin,end-1);
    }

    public static TreeNode handler(int[] nums, int begin, int end){
        if(begin > end) {
            return null;
        }
        if(begin == end) {
            return new TreeNode(nums[begin]);
        }
        int mid = (begin+end)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = handler(nums,begin,mid-1);
        node.right = handler(nums,mid+1,end);
        return node;
    }


    public static void main(String[] args) {
        TreeNode node = sortedArrayToBST(new int[]{-10,-3,0,5,9});

        int a =1;

    }

}
