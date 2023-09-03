package BinaryTree.LC404SumOfLeftLeaves;

public class Solution404 {
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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null || isLeaf(root))  return 0;
        if(isLeaf(root.left))   return root.left.val+sumOfLeftLeaves(root.right);
        return sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right);
    }
    public boolean isLeaf(TreeNode root){
        return root!=null && root.left==null && root.right==null;
    }
}
