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
    public int longestConsecutive(TreeNode root) {
        return helper(root)[0];
    }
    public int[] helper(TreeNode root){
        /* Return the longest consecutive path's length, and whether this path starts with root(0 No, 1 Yes)*/
        if(root==null)  return new int[]{0,0};
        if(root.left==null && root.right==null) return new int[]{1,1};
        int[] cur = new int[]{1,1};
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        if(root.left!=null && root.val==root.left.val-1){
            cur[0] = Math.max(cur[0],(left[1]==1?left[0]+1:2));
            cur[1] = 1;
        }
        if(root.right!=null && root.val==root.right.val-1){
            cur[0] = Math.max(cur[0],(right[1]==1?right[0]+1:2));
            cur[1] = 1;
        }
        if(cur[0]>=Math.max(left[0],right[0]))  return cur;
        return new int[]{Math.max(left[0],right[0]),0};
    }
}
