package LinkedList.LC148SortList;

public class Solution148 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode mid = getMid(head);
        ListNode midNext = mid.next;
        mid.next = null;
        return mergeTwoLists(sortList(head),sortList(midNext));
    }
    public ListNode getMid(ListNode head){
        ListNode slow = head, fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode mergeTwoLists(ListNode head1, ListNode head2){
        if(head1==null || head2==null){
            return head1==null?head2:head1;
        }
        ListNode head = head1.val<= head2.val? head1:head2;//GLOBAL head
        ListNode cur1 = head.next;
        ListNode cur2 = head==head1?head2:head1;
        ListNode tail = head;//GLOBAL tail
        while(cur1!=null && cur2!=null){
            if(cur1.val<=cur2.val){
                tail.next = cur1;
                cur1 = cur1.next;
            }else{
                tail.next = cur2;
                cur2 = cur2.next;
            }
            tail = tail.next;
        }
        tail.next = cur1==null?cur2:cur1;
        return head;
    }
}
