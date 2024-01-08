package BinaryTree.LC272ClosestBinarySearchTreeValueII;

import java.util.LinkedList;
import java.util.List;

public class Solution272 {
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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> ans = new LinkedList<>();
        helper(ans,root,target,k);
        return ans;
    }
    public void helper(LinkedList<Integer> ans,TreeNode root,double target,int k){
        if(root==null)  return;
        helper(ans,root.left,target,k);
        if(ans.size()==k){
            if(Math.abs(target-root.val)<Math.abs(target-ans.get(0))){
                ans.removeFirst();
            }else{
                return;
            }
        }
        ans.add(root.val);
        helper(ans,root.right,target,k);
    }
}
