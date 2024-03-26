package bst;

import tool.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现一个二叉搜索树迭代器类BSTIterator ，表示一个按中序遍历二叉搜索树（BST）的迭代器：
 * BSTIterator(TreeNode root) 初始化 BSTIterator 类的一个对象。BST 的根节点 root 会作为构造函数的一部分给出。指针应初始化为一个不存在于 BST 中的数字，且该数字小于 BST 中的任何元素。
 * boolean hasNext() 如果向指针右侧遍历存在数字，则返回 true ；否则返回 false 。
 * int next()将指针向右移动，然后返回指针处的数字。
 * 注意，指针初始化为一个不存在于 BST 中的数字，所以对 next() 的首次调用将返回 BST 中的最小元素。
 *
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 的中序遍历中至少存在一个下一个数字。
 *
 * 作者：LeetCode
 * 链接：https://leetcode.cn/leetbook/read/introduction-to-data-structure-binary-search-tree/xpg4qe/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class CodeBSITterator {

    List<Integer> list = new ArrayList<>();

    int point = -1;

    public CodeBSITterator(TreeNode root) {
        bfs(root);
    }

    public void bfs(TreeNode node) {
        if(null == node) {
            return ;
        }
        bfs(node.left);
        list.add(node.val);
        bfs(node.right);
    }


    public int next() {

        return list.get(++point);
    }


    public boolean hasNext() {
        return point+1 < list.size();

    }



}
