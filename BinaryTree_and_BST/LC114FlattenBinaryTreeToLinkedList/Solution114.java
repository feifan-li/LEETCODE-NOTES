package BinaryTree_and_BST.LC114FlattenBinaryTreeToLinkedList;

public class Solution114 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public void flatten(TreeNode root) {
        if(root==null) return;
        if(root.left==null && root.right==null) return;
        helper(root);
    }
    private TreeNode helper(TreeNode root){//return tail
        if(root==null) return null;
        if(root.left==null && root.right==null) return root;;
        if(root.left==null && root.right!=null) return helper(root.right);
        if(root.left!=null && root.right==null){
            root.right = root.left;
            root.left = null;
            return helper(root.right);
        }
        TreeNode left = root.left;
        TreeNode leftTail = helper(left);
        TreeNode right = root.right;
        TreeNode rightTail = helper(right);
        root.left = null;
        root.right = left;
        leftTail.right = right;
        return rightTail;
    }
}
