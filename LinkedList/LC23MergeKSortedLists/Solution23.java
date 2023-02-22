package LinkedList.LC23MergeKSortedLists;

import java.util.PriorityQueue;

public class Solution23 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeKLists(ListNode[] lists){
        if(lists==null || lists.length==0) return null;
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>((a,b)->a.val-b.val);//min-heap
        for(ListNode i:lists){
            if(i!=null) q.add(i);
        }
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        while(!q.isEmpty()){
            head.next = q.poll();
            head = head.next;
            if(head.next!=null){// add polled.next
                q.add(head.next);
            }
        }
        return dummy.next;
    }
}
