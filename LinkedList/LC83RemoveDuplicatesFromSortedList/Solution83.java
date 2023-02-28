package LinkedList.LC83RemoveDuplicatesFromSortedList;

public class Solution83 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode p = head;
        ListNode pNext;
        while(p.next!=null){
            pNext = p.next;
            if(p.val!=pNext.val){
                p = pNext;
            }else{
                ListNode tmp = pNext.next;
                pNext.next = null;
                p.next = tmp;
            }
        }
        return head;
    }
}
