import tool.ListNode;

public class Code21 {


    /**
     * l1/l2 中找出一个节点被源节点指向
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode h1 = new ListNode(0);
        ListNode reNode = h1;
        while (list1!=null && list2!=null) {
            if(list1.val <= list2.val) {
                h1.next = list1;
                list1 = list1.next;
            }else{
                h1.next = list2;
                list2 = list2.next;
            }
            h1 = h1.next;
        }
        h1.next = list1 == null? list2:list1;
        return reNode.next;

    }

    public static void main(String[] args) {

    }

}
