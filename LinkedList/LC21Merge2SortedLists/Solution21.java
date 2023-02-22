package LinkedList.LC21Merge2SortedLists;

public class Solution21 {
     public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode mergeTwoLists(ListNode head1, ListNode head2){
        if(head1==null || head2==null){
            return head1==null?head2:head1;
        }
        ListNode head = head1.val<= head2.val? head1:head2;//GLOBAL head
        ListNode cur1 = head.next;
        ListNode cur2 = head==head1?head2:head1;
        ListNode pre = head;
        while(cur1!=null && cur2!=null){
            if(cur1.val<=cur2.val){
                pre.next = cur1;
                cur1 = cur1.next;
            }else{
                pre.next = cur2;
                cur2 = cur2.next;
            }
            pre = pre.next;
        }
        pre.next = cur1==null?cur2:cur1;
        return head;
    }
}

