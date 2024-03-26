import tool.ListNode;

public class Code328 {

    public static ListNode oddEvenList(ListNode head) {

        if(head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode l1 = head;
        ListNode l2 = head.next;
        ListNode l2Head = head.next;

        while (l1.next!= null && l2.next != null) {
            l1 = handler(l1);
            l2 = handler(l2);
        }
        l1.next = l2Head;
        return head;
    }

    public static ListNode handler (ListNode l) {
        if (l.next == null) {
            return l;
        }
        if( l.next.next ==null) {
            l.next = null;
        }else {
            l.next = l.next.next;
            l = l.next;
        }
        return l;
    }


    public static void main(String[] args) {

        ListNode L5 =  new ListNode(7);
        ListNode L4 =  new ListNode(4,L5);
        ListNode L3 =  new ListNode(6,L4);
        ListNode L2 =  new ListNode(5,L3);
        ListNode L1 =  new ListNode(3,L2);
        ListNode L11 =  new ListNode(1,L1);
        ListNode L12 =  new ListNode(2,L11);

        ListNode L = oddEvenList(L12);

        while (L!=null) {
            System.out.print(L.val + " ");
            L = L.next;
        }
    }


}
