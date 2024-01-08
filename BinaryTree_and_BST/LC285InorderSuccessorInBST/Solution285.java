package BinaryTree_and_BST.LC285InorderSuccessorInBST;

public class Solution285 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root==null)  return null;
        if(root==p){
            return getLeftMost(root.right);
        }else if(root.val>p.val){
            TreeNode rightMost = getRightMost(root.left);
            if(rightMost==p)    return root;
            else if(rightMost==null || rightMost.val<p.val) return null;
            else return inorderSuccessor(root.left,p);
        }
        return inorderSuccessor(root.right,p);
    }
    public TreeNode getLeftMost(TreeNode root){
        if(root==null)   return root;
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }
    public TreeNode getRightMost(TreeNode root){
        if(root==null)   return root;
        while(root.right!=null){
            root = root.right;
        }
        return root;
    }
}
