package LinkedList.LC160IntersectionOfTwoLinkedLists;

public class Solution160 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==headB) return headA;
        ListNode pA = headA, pB = headB;
        int m = 0,n = 0;
        while(pA.next!=null){
            m++;
            pA = pA.next;
        }
        while(pB.next!=null){
            n++;
            pB = pB.next;
        }
        if(pA!=pB) return null;//no intersection
        pA = headA; pB = headB;
        if(m<n){
            for(int cnt = 0;cnt<n-m;++cnt){
                pB = pB.next;
            }
        }else{
            for(int cnt = 0;cnt<m-n;++cnt){
                pA = pA.next;
            }
        }
        while(pA.next!=null && pB.next!=null){
            if(pA==pB) return pA;
            pA = pA.next;
            pB = pB.next;
        }
        //finally intersect at tail
        return pA;
    }
}
