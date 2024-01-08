package BinaryTree_and_BST.LC156BinaryTreeUpsideDown;

public class Solution156 {
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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)){
            return root;
        }
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        TreeNode rootLeft = root.left;
        TreeNode rootRight = root.right;
        root.left = null;
        root.right = null;
        rootLeft.left = rootRight;
        rootLeft.right = root;
        return newRoot;
    }
}
