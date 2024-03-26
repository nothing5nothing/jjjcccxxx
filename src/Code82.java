import tool.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Code82 {

    public static ListNode deleteDuplicates(ListNode head) {

        List<ListNode> list = new ArrayList<>();
        int[] arr = new int[203];

        ListNode l = head;
        while (l!=null) {
            if(arr[l.val+100] == 0) {

                list.add(l);
            }
            arr[l.val+100] +=1;
            l = l.next;
        }
        for(int i = list.size()-1;i>=0;i--) {
            list.get(i).next = null;
            if(arr[list.get(i).val+100] >1) {
                list.remove(i);
            }
        }
        ListNode l1 = null;
        ListNode h1 = null;
        int index =0;
        for(ListNode listNode : list) {
            if(index ==0) {
                l1 = listNode;
                h1 = l1;
                index ++;
                continue;
            }
            l1.next = listNode;
            l1 = l1.next;
            index ++;
        }

        return h1;
    }

    public static void main(String[] args) {

        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(2,n1);
        ListNode n3 = new ListNode(1,n2);
        ListNode n4 = new ListNode(3,n3);
        ListNode n5 = new ListNode(4,n4);
        ListNode n6 = new ListNode(4,n5);
        ListNode n7 = new ListNode(5,n6);
        ListNode l = deleteDuplicates(n3);
        int a= 1;

    }

}
