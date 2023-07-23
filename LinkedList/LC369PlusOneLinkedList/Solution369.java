package LinkedList.LC369PlusOneLinkedList;

public class Solution369 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode plusOne(ListNode head) {
        ListNode carry = new ListNode(0,head);
        ListNode lastNoneNine = carry, p = carry;
        while(p!=null){
            if(p.val!=9)    lastNoneNine = p;
            p = p.next;
        }
        lastNoneNine.val++;
        while(lastNoneNine.next!=null){
            lastNoneNine = lastNoneNine.next;
            lastNoneNine.val = 0;
        }
        return carry.val==0?head:carry;
    }
}
