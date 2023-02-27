package LinkedList.LC61RotateList;

public class Solution61 {
     public class ListNode {
     int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return null;
        if(k==0) return head;
        int n = 1;
        ListNode tail = head;
        while(tail.next!=null){
            tail = tail.next;
            n++;
        }
        tail.next = head;
        //now the list become circular
        for(int i=1;i<=n-k%n;++i){
            tail = tail.next;
            head = head.next;
        }
        tail.next = null;
        return head;
    }
}
