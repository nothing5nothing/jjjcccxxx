import tool.nextNode.Node;

import java.util.*;

public class Code117 {

    /**
     * 1、bfs遍历每一个指向后面一个node
     * 2、再遍历一次 把最右面一条线遍历置为null
     * @param root
     * @return
     */
    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(root);
        Node temp = null;
        int count = 0;
        while (!queue.isEmpty()) {
            temp = queue.poll();
            count++;
            if(temp.left!=null) queue.add(temp.left);
            if(temp.right!=null) queue.add(temp.right);
            if(!queue.isEmpty()) {
                temp.next = queue.peek();
            }
        }
        List<Node> list = new ArrayList<>();
        dfs(root, list, 0);
        list.forEach(x->{
            x.next=null;
        });
        return root;
    }

    public static void dfs(Node node,List<Node> list,int index) {
        if(node == null) return;
        if(list.size()>index) {
            list.set(index,node);
        }else{
            list.add(node);
        }
        dfs(node.left, list, index+1);
        dfs(node.right, list, index+1);
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(2);
        Node node4 = new Node(3);
        Node node5 = new Node(3);
        Node node6 = new Node(4);
        Node node7 = new Node(4);
        node1.left=node2;
        node1.right=node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node6;
        node4.right = node7;
        Node node = connect(node1);
        int a =1;
    }
}
