package CompanyQuestions.HuaweiJishi.链表.HJ51输出单向链表中倒数第k个结点;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int value){
            this.val = value;
        }
        ListNode(int value,ListNode p){
            this.val = value;
            this.next = p;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> ans = new ArrayList<>();
        while(in.hasNext()){
            int _n = in.nextInt();
            ListNode head = new ListNode(in.nextInt(),null);
            ListNode prev = head;
            for(int i=1;i<_n;++i){
                ListNode cur = new ListNode(in.nextInt(),null);
                prev.next = cur;
                prev = cur;
            }
            int k = in.nextInt();
            ans.add(process(head,k));
        }
        for(int i=0;i<ans.size();++i){
            System.out.println(ans.get(i));
        }
    }
    public static int process(ListNode head,int k){
        int n = 0;
        ListNode p = head;
        while(p!=null){
            n++;
            p = p.next;
        }
        p = head;
        int _n = 0;
        while(p!=null){
            _n++;
            if(_n==n-k+1)   return p.val;
            p = p.next;
        }
        return -1;
    }
}
