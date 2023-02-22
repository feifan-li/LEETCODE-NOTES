package LinkedList.LC25ReverseNodesKGroup;

public class Solution25 {
    // 不要提交这个类
    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public static ListNode reverseKGroup(ListNode head, int k){
        ListNode start = head;
        ListNode end = getKGroupEnd(start,k);
        if(end==null){ // less that k nodes starting from Node start
            return head;
        }
        head = end;//GLOBAL head Node to return
        reverse(start,end);//reverse first k Nodes
        ListNode lastEnd = start;//lastEnd: end Node of last reversed group
        while(lastEnd.next!=null){
            start = lastEnd.next;
            end = getKGroupEnd(start,k);
            if(end == null) return head;
            reverse(start,end);
            lastEnd.next = end;//link last reversed k Nodes to current reversed k Nodes
            lastEnd = start;//update lastEnd
        }
        return head;
    }
    public static ListNode getKGroupEnd(ListNode start, int k){
        //考察边界条件！
        while(--k!=0 && start!=null){
            start = start.next;
        }
        return start;
    }
    public static void reverse(ListNode start,ListNode end){//after reversing, should not be detached from following Nodes
        end = end.next;
        ListNode cur = start;
        ListNode pre = null;
        ListNode next = null;
        while(cur!=end){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
    }
}
