import tool.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Code86 {

    public static ListNode partition(ListNode head, int x) {

        List<ListNode> l = new ArrayList<>();
        List<ListNode> s = new ArrayList<>();
        ListNode h = head;
        ListNode n;
        while (h!=null) {
            n=h.next;
            h.next = null;
            if(h.val>=x) {
                l.add(h);
            }else {
                s.add(h);
            }
            h=n;
        }
        h = new ListNode();
        ListNode end = h;
        if(s.size()>0) {
            for(ListNode ln: s){
                end.next = ln;
                end = end.next;
            }
        }
        if(l.size()>0) {
            for(ListNode ln: l){
                end.next = ln;
                end = end.next;
            }
        }
        return h.next;

    }


    public static void main(String[] args) {

//        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(5,n2);
        ListNode n4 = new ListNode(2,n3);
        ListNode n5 = new ListNode(3,n4);
        ListNode n6 = new ListNode(4,n5);
        ListNode n7 = new ListNode(1,n6);
        ListNode l = partition(n7, 3);
        int a = 0;
    }

}
