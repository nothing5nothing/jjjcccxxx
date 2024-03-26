import tool.ListNode;

public class Code148 {

    public static ListNode sortList(ListNode head) {
        if(head == null) {
            return head;
        }

        ListNode sortNode = sortList(head.next);
        head.next =null;
        return sortInsert(head, sortNode);
    }




    /**
     * 把 node 插入 sortNode 中
     * @param node
     * @param sortNode
     * @return
     */
    public static ListNode sortInsert(ListNode node, ListNode sortNode) {
        if(sortNode == null) {
            return node;
        }
        ListNode head = sortNode;
        if(node.val < head.val) {
            node.next = head;
            return node;
        }
        ListNode tail = head.next;
        while(tail != null) {
            if(node.val <= tail.val) {
                head.next = node;
                node.next = tail;
                return sortNode;
            }
            head = head.next;
            tail = tail.next;
        }
        head.next = node;
        return sortNode;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode node = sortList(n1);
        int a =1;


    }
}
