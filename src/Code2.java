import tool.ListNode;

import java.util.ListIterator;

public class Code2 {


    public static void main(String[] args) {

        ListNode l1 = new ListNode(9);
        ListNode l12 = new ListNode(9,l1);
        ListNode l13 = new ListNode(9,l12);
        ListNode l14 = new ListNode(9,l13);
        ListNode l15 = new ListNode(9,l14);
        ListNode l16= new ListNode(9,l15);
        ListNode l17 = new ListNode(9,l16);
        ListNode l18 = new ListNode(9,l17);
        ListNode l2 = new ListNode(9, l18);
        ListNode l3 = new ListNode(1, l2);

        ListNode r1 = new ListNode(9);
        //ListNode r2 = new ListNode(6, r1);


        ListNode a = addTwoNumbers(l3,r1 );
        int as = 1;
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int sum = 0;
        int index = 1;
        int value1 = 0,value2=0;
        ListNode h1 = l1,h2=l2;
        ListNode head = new ListNode();
        ListNode tail = head;
        while (h1 != null || h2 != null) {
            value1 =  h1 == null ? 0 :  h1.val;
            value2 =  h2 == null ? 0 :  h2.val;
            sum += (value1+value2) * index;

            tail.next = new ListNode(sum%10);
            tail = tail.next;

            sum = sum/10;

            h1 = h1 != null ? h1.next : null;
            h2 = h2 != null ? h2.next : null;
        }
        if(sum>0) {
            tail.next = new ListNode(sum%10);
        }
        return head.next;
    }


}
