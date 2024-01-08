package BinaryTree_and_BST.LC101SymmetricTree;

public class Solution101 {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);
    }
    public boolean isMirror(TreeNode h1,TreeNode h2){
        if(h1==null^h2==null) return false;
        if(h1==null&&h2==null) return true;
        return h1.val==h2.val && isMirror(h1.left,h2.right) && isMirror(h1.right,h2.left);
    }
}
