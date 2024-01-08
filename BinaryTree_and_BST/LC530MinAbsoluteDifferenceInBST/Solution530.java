package BinaryTree_and_BST.LC530MinAbsoluteDifferenceInBST;

public class Solution530 {
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
    public int minDiff = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        helper(root);
        return minDiff;
    }
    public int[] helper(TreeNode root){
        if(root==null)  return new int[2];
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        if(root.left!=null)     minDiff = Math.min(minDiff,root.val - left[1]);
        if(root.right!=null)    minDiff = Math.min(minDiff,right[0] - root.val);
        return new int[]{(root.left==null?root.val:left[0]),(root.right==null?root.val:right[1])};
    }
}
