package BFS.LC117PopulatingNextRightPointerInEachNodeII;

public class Solution117 {
    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
        public Node() {}
        public Node(int _val) {
            val = _val;
        }
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    public Node prev,level;
    public Node connect(Node root) {
        if(root==null) return null;
        level = root;
        Node cur = level;
        while(level!=null){
            prev = null;
            cur = level;
            level = null;
            while(cur!=null){
                processChild(cur.left);
                processChild(cur.right);
                cur = cur.next;
            }
        }
        return root;
    }
    private void processChild(Node child){
        if(child==null) return;
        if(prev!=null) prev.next = child;
        else level = child;
        prev = child;
    }
}
