import tool.ListNode;

public class Code206 {

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode end = head.next;
        head.next = null;
        while (end!=null) {
            ListNode mid = end;
            end = end.next;
            mid.next = head;
            head = mid;
        }
        return head;
    }

    public static void main(String[] args) {
//        ListNode l5 = new ListNode(5);
//        ListNode l4 = new ListNode(4,l5);
//        ListNode l3 = new ListNode(3,l4);
        ListNode l2 = new ListNode(2);
        ListNode l1 = new ListNode(1,l2);
        ListNode value = reverseList(l1);
        while(value!=null) {
            System.out.print(value.val);
            value = value.next;
        }
    }
}
