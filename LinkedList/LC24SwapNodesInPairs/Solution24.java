package LinkedList.LC24SwapNodesInPairs;

public class Solution24 {
     public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode swapPairs(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            ListNode nextFast = fast.next.next;
            slow.next = fast.next;
            fast.next.next = fast;
            fast.next = nextFast;
            slow = fast;
            fast = nextFast;
        }
        return dummy.next;
    }
}
