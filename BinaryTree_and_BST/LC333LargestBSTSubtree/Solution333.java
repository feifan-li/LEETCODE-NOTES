package BinaryTree.LC333LargestBSTSubtree;

public class Solution333 {
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
    public int res = 0;
    public int largestBSTSubtree(TreeNode root) {
        if(root==null)  return res;
        countAndCheckBST(root);
        return res;
    }
    public int[] countAndCheckBST(TreeNode root){
        if(root==null)  return new int[]{0,Integer.MAX_VALUE,Integer.MIN_VALUE};//[#, min, max]
        int[] left = countAndCheckBST(root.left);
        int[] right = countAndCheckBST(root.right);
        if(left[0]==-1 || right[0]==-1 || left[2]>=root.val || right[1]<=root.val){
            return new int[]{-1,0,0};//-1 # of nodes means not a BST
        }
        int size = left[0]+right[0]+1;
        res = Math.max(res,size);
        return new int[]{size,Math.min(root.val,left[1]),Math.max(root.val,right[2])};//handle null child
    }
}
