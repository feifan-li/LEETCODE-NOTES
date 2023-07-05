package LinkedList.LC328OddEvenLinkedList;

public class Solution328 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null)   return head;
        ListNode oddHead = head, oddTail = head, evenHead = head.next, evenTail = head.next;
        ListNode p = evenTail;
        int cnt = 2;
        while(p.next!=null){
            p = p.next;
            cnt++;
            if(cnt%2==0){
                evenTail = p;
            }else{
                evenTail.next = p.next;
                p.next = evenHead;
                oddTail.next = p;
                oddTail = oddTail.next;
                p = evenTail;
            }
        }
        return oddHead;
    }
}
