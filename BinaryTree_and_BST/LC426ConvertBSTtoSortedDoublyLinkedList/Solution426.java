package BinaryTree_and_BST.LC426ConvertBSTtoSortedDoublyLinkedList;

public class Solution426 {
    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
    public Node treeToDoublyList(Node root) {
        if(root==null)  return null;
        Node head = getLeftMost(root);
        Node tail = getRightMost(root);
        transform(root);
        tail.right = head;
        head.left = tail;
        return head;
    }
    public void transform(Node root){
        if(root==null)  return;
        Node pre = getRightMost(root.left);
        Node succ = getLeftMost(root.right);
        transform(root.left);
        transform(root.right);
        root.left = pre;
        if(pre!=null) pre.right = root;
        root.right = succ;
        if(succ!=null) succ.left = root;
    }
    public Node getLeftMost(Node root){
        if(root==null)  return null;
        while(root.left!=null)   root = root.left;
        return root;
    }
    public Node getRightMost(Node root){
        if(root==null)  return null;
        while(root.right!=null)   root = root.right;
        return root;
    }
}
