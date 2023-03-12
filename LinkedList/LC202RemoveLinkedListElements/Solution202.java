package LinkedList.LC202RemoveLinkedListElements;

public class Solution202 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0,head);
        ListNode prev = dummy;
        while(head!=null){
            if(head.val==val){
                head = head.next;
                prev.next = head;
            }else{
                prev = head;
                head = head.next;
            }
        }
        return dummy.next;
    }
}
