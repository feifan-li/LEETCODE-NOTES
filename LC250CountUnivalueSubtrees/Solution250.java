package LC250CountUnivalueSubtrees;

import java.util.ArrayList;

public class Solution250 {
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
    public int ans = 0;
    public int countUnivalSubtrees(TreeNode root) {
        return helper(root)?ans:ans;
    }
    private Boolean helper(TreeNode root){
        if(root==null)  return true;
        Boolean left = helper(root.left);
        Boolean right = helper(root.right);
        if(!(left && right))                                    return false;
        else if(root.left!=null && root.val!=root.left.val)     return false;
        else if(root.right!=null && root.val!=root.right.val)   return false;
        ans++;
        return true;
    }
}
