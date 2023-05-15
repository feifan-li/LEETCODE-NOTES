package LinkedList.LC1721SwappingNodesInALinkedList;

public class Solution1721 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode swapNodes(ListNode head, int k) {
        int n = 0;
        ListNode a=null,b=null;
        ListNode p = head;
        while(p!=null){
            n++;
            if(b!=null) b = b.next;
            if(n==k){
                a = p;
                b = head;
            }
            p = p.next;
        }
        //swap value
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
        return head;
    }
}
