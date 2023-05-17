package LinkedList.LC2130MaxTwinSumOfALinkedList;

public class Solution2130_2 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public int pairSum(ListNode head) {
        //O(1) space solution
        int max = Integer.MIN_VALUE;
        ListNode slow = head,fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode headSecondHalf = slow.next;
        slow.next = null;
        ListNode head2 = reverse(headSecondHalf);
        slow = head;fast = head2;
        while(slow!=null && fast!=null){
            max = Math.max(max,slow.val+fast.val);
            slow = slow.next;
            fast = fast.next;
        }
        return max;
    }
    public ListNode reverse(ListNode head){
        if(head==null || head.next==null)   return head;
        ListNode p = head,nextP = null,pPrev = null;
        while(p!=null){
            nextP = p.next;
            p.next = pPrev;
            pPrev = p;
            p = nextP;
        }
        return pPrev;
    }
}
