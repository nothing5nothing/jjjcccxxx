import tool.GraphNode.Node;

import java.util.*;

public class Code380 {

    /**
     * 1、bfs
     * 2、map 存储隐射
     *
     * @param node
     * @return
     */
    public static Node cloneGraph(Node node) {
        if(node == null) {
            return node;
        }

        Map<Integer, Node> map = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        Node head = new Node(node.val);
        map.put(head.val, head);
        while( !queue.isEmpty()) {
            Node old = queue.poll();
            Node newTemp = map.containsKey(old.val) ? map.get(old.val) : new Node(old.val);
            map.put(newTemp.val,  newTemp);
            for(Node oldN : old.neighbors) {
                if(!map.containsKey(oldN.val)) {
                    map.put(oldN.val, new Node(oldN.val));
                }
                Node newN = map.get(oldN.val);
                if(newTemp.neighbors.contains(newN) && newN.neighbors.contains(newTemp)) {
                    continue;
                }
                if(!newTemp.neighbors.contains(newN)) {
                    newTemp.neighbors.add(newN);
                }
                if(!newN.neighbors.contains(newTemp)) {
                    newN.neighbors.add(newTemp);
                }
                queue.add(oldN);
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors = Arrays.asList(node2, node4);
        node2.neighbors = Arrays.asList(node1, node3);
        node3.neighbors = Arrays.asList(node2, node4);
        node4.neighbors = Arrays.asList(node1, node3);
        Node node = cloneGraph(node1);
        int a = 1;
    }


}
