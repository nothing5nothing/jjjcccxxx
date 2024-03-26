import com.sun.source.tree.BreakTree;
import tool.ListNode;

import java.util.HashMap;
import java.util.Map;

public class Code141 {

    public boolean hasCycle(ListNode head) {

        Map<ListNode,Integer> map = new HashMap<>();

        while (head != null) {
            if(map.containsKey(head)) {
                return true;
            }
            map.put(head,1);
            head = head.next;
        }
        return false;


    }

    public static void main(String[] args) {

    }



}
