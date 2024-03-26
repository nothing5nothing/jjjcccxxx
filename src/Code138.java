import tool.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Code138 {

    public static Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        List<Node> listNew = new ArrayList<>();
        List<Node> listOld = new ArrayList<>();

        Node h1= head;
        Node l1 = head;

        Node newHead = new Node(l1.val);
        Node newEnd = newHead;
        listNew.add(newHead);
        listOld.add(head);
        while (l1.next!=null) {
            l1 = l1.next;
            listOld.add(l1);
            newEnd.next = new Node(l1.val);
            newEnd = newEnd.next;
            listNew.add(newEnd);
        }

        int[] index = new int[listOld.size()];
        Node l2 = head;
        int k =0;
        while (l2 != null) {
            for(int i=0;i<listOld.size();i++) {
                if(l2.random == null) {
                    index[k] = -1;
                }
                if(l2.random == listOld.get(i)) {
                    index[k] = i;
                }
            }
            k++;
            l2=l2.next;
        }

        Node reNode= newHead;
        int ind = 0;
        while (reNode != null) {
            if(index[ind] == -1) {
                reNode = reNode.next;
                ind++;
                continue;
            }
            reNode.random = listNew.get(index[ind]);
            reNode = reNode.next;
            ind++;
        }
        return newHead;
    }


    // 官方 回溯！！！！！
    Map<Node, Node> cachedNode = new HashMap<Node, Node>();

    public Node copyRandomList1(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }


    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        node1.next = node2;
        node1.random = null;
        node2.next = node3;
        node2.random = node1;
        node3.next = node4;
        node3.random = node5;
        node4.next = node5;
        node4.random = node3;
        node5.random = node1;

        Node re = copyRandomList(node1);
        int a= 0;
    }


}
