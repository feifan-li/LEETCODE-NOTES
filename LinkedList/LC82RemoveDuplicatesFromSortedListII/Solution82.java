package LinkedList.LC82RemoveDuplicatesFromSortedListII;

public class Solution82 {
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode dummy = new ListNode(-1,head);
        ListNode prev = dummy;
        ListNode p = head;
        while(p!=null && p.next!=null){
            if(p.val!=(p.next).val){
                prev = p;
                p = p.next;
            }else{
                int val = p.val;
                while(p!=null && p.val==val){
                    ListNode tmp = p;
                    p = p.next;
                    tmp.next = null;
                    prev.next = p;
                }
            }
        }
        return dummy.next;
    }
}
