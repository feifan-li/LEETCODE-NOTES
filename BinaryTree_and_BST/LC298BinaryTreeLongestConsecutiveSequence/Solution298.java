package BinaryTree.LC298BinaryTreeLongestConsecutiveSequence;

public class Solution298 {
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
    public int res;
    public int longestConsecutive(TreeNode root) {
        helper(root,0,root.val);
        return res;
    }
    public void helper(TreeNode root,int max,int target){
        if(root==null) return;
        if(root.val==target)    max++;
        else    max=1;
        res = Math.max(res,max);
        helper(root.left,max,root.val+1);
        helper(root.right,max,root.val+1);
    }

}
