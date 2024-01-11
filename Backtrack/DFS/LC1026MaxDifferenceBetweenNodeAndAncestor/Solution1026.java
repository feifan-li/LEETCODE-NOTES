package Backtrack.DFS.LC1026MaxDifferenceBetweenNodeAndAncestor;

public class Solution1026 {
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
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public int dfs(TreeNode root,int max,int min){
        if(root==null){
            return max-min;
        }
        max = Math.max(max,root.val);
        min = Math.min(min,root.val);
        int leftRange = dfs(root.left,max,min);
        int rightRange = dfs(root.right,max,min);
        return Math.max(leftRange,rightRange);
    }
}
