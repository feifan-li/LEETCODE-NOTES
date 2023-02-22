package LinkedList.LC21Merge2SortedLists;

public class Solution21 {
     public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if(list1==null) return list2;
            if(list2==null) return list1;
            ListNode dummy = new ListNode();
            ListNode head = dummy;
            while(list1!=null && list2!=null){
                if(list1.val<=list2.val){
                    head.next = list1;
                    list1 = list1.next;
                }else{
                    head.next = list2;
                    list2 = list2.next;
                }
                head = head.next;
            }
            head.next = list1==null? list2:list1;
            return dummy.next;
        }
}

