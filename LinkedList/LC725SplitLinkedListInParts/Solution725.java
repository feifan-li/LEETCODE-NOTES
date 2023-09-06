package LinkedList.LC725SplitLinkedListInParts;

import java.util.Arrays;

public class Solution725 {
     public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        Arrays.fill(ans,null);
        if(head==null)  return ans;
        ans[0] = head;
        int[] len = new int[k];
        int n = 1;
        ListNode p = head;
        while(p.next!=null){
            p = p.next;
            n++;
        }
        Arrays.fill(len,n/k);
        int r = n%k;
        for(int i=0;i<k;++i){
            if(r>0){
                len[i] += 1;
                r--;
            }
        }
        p = head;
        for(int i=1;i<k && len[i]>0;++i){
            int hops = len[i-1];
            while(hops-1>0){
                p = p.next;
                hops--;
            }
            ans[i] = p.next;
            p.next = null;
            p = ans[i];
        }
        return ans;
    }
}
