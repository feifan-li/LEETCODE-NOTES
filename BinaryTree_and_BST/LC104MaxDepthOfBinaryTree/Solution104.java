package BinaryTree_and_BST.LC104MaxDepthOfBinaryTree;

public class Solution104 {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }
    public int maxDepth(TreeNode root) {
        return root==null ? 0 : Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
