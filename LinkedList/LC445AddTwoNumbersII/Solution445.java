package LinkedList.LC445AddTwoNumbersII;

import java.util.ArrayList;

public class Solution445 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ListNode p = l1;
        while(p!=null){
            arr1.add(p.val);
            p = p.next;
        }
        ArrayList<Integer> arr2 = new ArrayList<>();
        p = l2;
        while(p!=null){
            arr2.add(p.val);
            p = p.next;
        }
        int carry = 0, i = arr1.size()-1, j = arr2.size()-1;
        ListNode cur = null,curNext = null;
        while(i>=0 || j>=0){
            int res = (i>=0?arr1.get(i):0)+(j>=0?arr2.get(j):0)+carry;
            carry = res>=10?1:0;
            if(curNext==null)   curNext = new ListNode(res-carry*10);
            else if(cur==null)  cur = new ListNode(res-carry*10,curNext);
            else{
                curNext = cur;
                cur = new ListNode(res-carry*10,curNext);
            }
            i--;
            j--;
        }
        if(carry==0)    return cur==null?curNext:cur;
        return new ListNode(carry,(cur==null?curNext:cur));
    }
}
