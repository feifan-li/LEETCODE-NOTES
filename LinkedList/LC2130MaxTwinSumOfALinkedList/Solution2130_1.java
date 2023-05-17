package LinkedList.LC2130MaxTwinSumOfALinkedList;

public class Solution2130_1 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public int pairSum(ListNode head) {
        //one-shot solution
        int max = Integer.MIN_VALUE;
        int[] stack = new int[50000];
        int top = -1;
        ListNode slow = head,fast = head;
        while(fast!=null && fast.next!=null){
            stack[++top] = slow.val;
            slow = slow.next;
            fast = fast.next.next;
        }
        while(slow!=null){
            max = Math.max(max,stack[top--]+slow.val);
            slow = slow.next;
        }
        return max;
    }
}
