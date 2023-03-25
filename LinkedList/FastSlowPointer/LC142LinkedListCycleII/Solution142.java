package LinkedList.FastSlowPointer.LC142LinkedListCycleII;

public class Solution142 {
     class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }
    //快慢双指针，同时于head开始
    //设head至环起始节点answer之间有x跳
    //快慢指针首次相遇于环内meet节点，设slow走过了y跳，则fast走过了2y跳，fast比slow多走过的跳数(2y-y=y)正好是环的跳数(y)
    //y>=x， 则answer至meet间有y-x跳，那么meet通过环走至answer要x跳
    //如果此时一个节点从head开始走，一个节点从meet开始走，那么x跳后他们一定会相遇于answer!
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                slow = head;
                while(slow!=fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
