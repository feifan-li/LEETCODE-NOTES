package BinaryTree.LC116PolulatingNextRightPointerInEachNode;

public class Solution116_2 {
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
    public Node connect(Node root) {
        if(root==null) return null;
        Node level = root;
        while(level.left!=null){
            Node cur = level;
            while(cur!=null){
                cur.left.next = cur.right;//left child to right child
                if(cur.next!=null) cur.right.next = cur.next.left;//right child to neighbour's left child
                cur = cur.next;//connected by above level
            }
            level = level.left;
        }
        return root;
    }
}
