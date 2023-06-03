package BinaryTree.LC226InvertBinaryTree;

public class Solution226 {
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
    public TreeNode invertTree(TreeNode root) {
        if(root==null)  return root;
        if(root.left==null && root.right==null) return root;
        TreeNode rightAfter = invertTree(root.left);
        TreeNode leftAfter = invertTree(root.right);
        root.left = leftAfter;
        root.right = rightAfter;
        return root;
    }
}
