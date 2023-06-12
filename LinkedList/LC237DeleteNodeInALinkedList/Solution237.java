package LinkedList.LC237DeleteNodeInALinkedList;

public class Solution237 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public void deleteNode(ListNode node) {
        node.val = node.next.val;//original val does not exist any more
        node.next = node.next.next;//the actual node removed from linked list is node.next,
        //but node.next is not removed from memory
    }
}
