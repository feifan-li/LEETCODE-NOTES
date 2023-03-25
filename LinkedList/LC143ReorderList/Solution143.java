package LinkedList.LC143ReorderList;

public class Solution143 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public void reorderList(ListNode head1) {
        ListNode slow = head1;
        ListNode fast = head1;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode slowNext = slow.next;
        slow.next = null;
        ListNode head2 = reverseLinkedList(slowNext);
        //merge
        ListNode p = head1;
        ListNode pPrev = null;
        ListNode p1 = head1,p2 = head2;
        while(p1!=null && p2!=null){
            p1 = p1.next;
            p.next = p2;
            p2 = p2.next;
            p = p.next;
            p.next = p1;
            pPrev = p;
            p = p.next;
        }
        if(p2!=null) pPrev.next = p2;
    }
    public ListNode reverseLinkedList(ListNode head){
        ListNode pre = null;
        ListNode next = null;
        while(head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
