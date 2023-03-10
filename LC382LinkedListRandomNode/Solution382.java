package LC382LinkedListRandomNode;

import java.util.ArrayList;

public class Solution382 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ArrayList<Integer> nodes = new ArrayList<>();
    public Solution382(ListNode head) {
        while(head!=null){
            nodes.add(head.val);
            head = head.next;
        }
    }

    public int getRandom() {
        int index = (int)(Math.random()*nodes.size());//[0,length-1]
        return this.nodes.get(index);
    }
}
