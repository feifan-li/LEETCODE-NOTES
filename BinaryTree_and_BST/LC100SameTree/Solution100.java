package BinaryTree_and_BST.LC100SameTree;

public class Solution100 {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        else if(p!=null && q==null) return false;
        else if(p==null && q!=null) return false;
        else if(p.val == q.val){
            boolean leftSame = isSameTree(p.left,q.left);
            boolean rightSame = isSameTree(p.right,q.right);
            return leftSame && rightSame;
        }else{
            return false;
        }
    }
}
