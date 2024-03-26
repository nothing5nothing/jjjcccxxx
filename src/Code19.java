import tool.ListNode;

public class Code19 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null) {
            return null;
        }

        if(head.next.next == null) {
            if(n==1) {
                head.next=null;
                return head;
            }
            head = head.next;
            return head;
        }

        // 找到 该节点父节点

        // 1. 查询一共多少节点
        int count = 1;
        ListNode l1 = head;
        while(l1.next!=null) {
            l1 = l1.next;
            count++;
        }

        // 删除第一个
        if(count == n) {
            head = head.next;
            return head;
        }

        int index = count - n;
        // 删除对应节点
        l1 = head;
        while (index > 1) {
            l1 = l1.next;
            index -- ;
        }

        l1.next = l1.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode L5 = new ListNode(7);
        ListNode L4 = new ListNode(4, L5);
        ListNode L3 = new ListNode(5);
        ListNode L2 = new ListNode(4, L3);
        ListNode L1 = new ListNode(3);
        ListNode L11 = new ListNode(2, L1);
        ListNode L12 = new ListNode(1, L11);

        ListNode L = removeNthFromEnd(L12, 1);

        while (L != null) {
            System.out.print(L.val + " ");
            L = L.next;
        }
    }
}
