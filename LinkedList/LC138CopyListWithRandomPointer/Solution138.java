package LinkedList.LC138CopyListWithRandomPointer;

public class Solution138 {
    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        //A->B->C ==> A->_A->B->_B->C->_C
        Node p = head;
        while(p!=null){
            Node _p = new Node(p.val);
            _p.next = p.next;
            p.next = _p;
            p = _p.next;
        }
        //copy random pointer
        p = head;
        while(p!=null){
            if(p.random!=null)  p.next.random = p.random.next;
            p = p.next.next;
        }
        //A->_A->B->_B->C->_C ==> A->B->C, _A->_B->_C
        p = head;
        Node _head = head.next;
        Node _p = _head;
        while(p!=null){
            p.next = _p.next;
            _p.next = p.next==null?null:p.next.next;
            p = p.next;
            _p = _p.next;
        }
        return  _head;
    }
}
