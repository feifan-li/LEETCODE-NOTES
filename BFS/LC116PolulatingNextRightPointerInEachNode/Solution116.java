package BFS.LC116PolulatingNextRightPointerInEachNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution116 {
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
        //initially, all next pointers are set to null
        if(root==null) return null;
        if(root.left==null && root.right==null) return root;
        Queue<Node> q = new LinkedList<Node>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            Node pre = null;
            for(int i=0;i<size;++i){
                Node cur = q.poll();
                if(pre!=null) pre.next = cur;
                pre = cur;
                if(cur.left!=null) q.offer(cur.left);
                if(cur.right!=null) q.offer(cur.right);
            }
        }
        return root;
    }
}
