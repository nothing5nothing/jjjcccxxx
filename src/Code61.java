import tool.ListNode;

public class Code61 {

    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0) {
            return head;
        }

        ListNode l = head;
        int len = 0;
        while(l!=null) {
            l=l.next;
            len++;
        }
        int index = k%len;
        if(index == 0) {
            return head;
        }
        index = len-index;

                l=head;
        while( index-- > 1 ){
            l=l.next;
        }
        ListNode h1 = l.next;
        ListNode l2 = h1;
        l.next = null;
        while(l2.next!=null) {
            l2=l2.next;
        }
        l2.next = head;
        return h1;
    }

    public static void main(String[] args) {
//        ListNode n1 = new ListNode(2);
//        ListNode n2 = new ListNode(2,n1);
//        ListNode n3 = new ListNode(5);
//        ListNode n4 = new ListNode(4,n3);
//        ListNode n5 = new ListNode(3,n4);
        ListNode n6 = new ListNode(2);
        ListNode n7 = new ListNode(1,n6);

        ListNode l = rotateRight(n7,1);
        int a=1;
    }


}
