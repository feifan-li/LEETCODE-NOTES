package LC382LinkedListRandomNode;

public class Solution382_AlgorithmR {
    //Follow up:
    //do random sampling over a population of unknown size with constant space
    //Reservoir sampling: Algorithm R
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode head;
    public Solution382_AlgorithmR(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        ListNode p = head;
        int ans = p.val;
        int length=0;
        while(p!=null){
            length++;
            if(0 == (int)(Math.random()*length)) ans = p.val;
            p = p.next;
        }
        return ans;
    }
}
