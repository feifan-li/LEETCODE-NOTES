package BinaryTree.LC270ClosestBinarySearchTreeValue;

public class Solution270 {
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
    public int closestValue(TreeNode root, double target) {
        if(root.left==null && root.right==null) return root.val;
        int leftMax = root.left==null?root.val:getMax(root.left);
        int rightMin = root.right==null?root.val:getMin(root.right);
        if(target<=root.val*1.0){
            if(target>=leftMax*1.0)     return (root.val*1.0-target)<(target-leftMax*1.0)?root.val:leftMax;
            return root.left==null?root.val:closestValue(root.left,target);
        }
        if(target<=rightMin*1.0)    return (rightMin*1.0-target)<(target-root.val*1.0)?rightMin:root.val;
        return root.right==null?root.val:closestValue(root.right,target);
    }
    public int getMax(TreeNode root){
        return root.right==null?root.val:getMax(root.right);
    }
    public int getMin(TreeNode root){
        return root.left==null?root.val:getMin(root.left);
    }
}
