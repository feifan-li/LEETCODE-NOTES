package BinaryTree_and_BST.LC112PathSum;

public class Solution112 {
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
    //number of paths = number of leaves
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        else if(root.left==null && root.right==null) return targetSum==root.val;
        else{
            boolean ans = hasPathSum(root.left,targetSum-root.val);
            ans |= hasPathSum(root.right,targetSum-root.val);
            return ans;
        }
    }
}
