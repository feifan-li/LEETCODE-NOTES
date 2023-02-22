package LinkedList.LC02AddTwoNumbers;

public class Solution02 {
    // 不要提交这个类
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //no extra space, make change in long list
        int len1 = listLength(l1);
        int len2 = listLength(l2);
        ListNode l = len1>len2? l1:l2;//long list
        ListNode s = l == l1 ? l2 : l1;//short list
        ListNode curL = l;
        ListNode tailL = l;
        ListNode curS = s;
        int carry = 0;
        //1)phase 1:
        while(curS!=null){
            int curNum = curL.val+curS.val+carry;
            curL.val = curNum%10;
            carry = curNum/10;
            tailL = curL;
            curL = curL.next;
            curS = curS.next;
        }
        //2)phase 2:
        while(curL!=null){
            int curNum = curL.val+carry;
            curL.val = curNum%10;
            carry = curNum/10;
            tailL = curL;
            curL = curL.next;
        }
        //3)phase 3:
        if(carry!=0){
            ListNode carryNode = new ListNode(1);
            tailL.next = carryNode;
        }
        return l;
    }
    //get list length
    public static int listLength(ListNode head){
        int len = 0;
        while(head!=null){
            len++;
            head = head.next;
        }
        return len;
    }
}
