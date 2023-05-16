package LinkedList.LC147InsertionSortList;

public class Solution147 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode insertionSortList(ListNode head) {
        if(head.next==null) return head;
        ListNode p=head.next,pPrev = head,pNext = null;
        while(p!=null){
            pNext = p.next;
            //if already sorted, continue to next iteration
            if(pPrev.val<=p.val){
                pPrev = p;
                p = pNext;
                continue;
            }
            //remove p from list
            p.next = null;
            pPrev.next = pNext;
            //find the location and insert p
            if(p.val<=head.val){
                p.next = head;
                head = p;
                p = pNext;
                continue;
            }
            ListNode q = head;
            while(q!=pPrev){
                if(q.val<=p.val && p.val<=q.next.val){
                    p.next = q.next;
                    q.next = p;
                    break;
                }
                q = q.next;
            }
            p = pNext;
        }
        return head;
    }
}
