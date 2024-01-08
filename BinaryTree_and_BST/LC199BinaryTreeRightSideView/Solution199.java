package BinaryTree.LC199BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.List;

public class Solution199 {
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
    public List<Integer> ans = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return ans;
        dfs(root,0);
        return ans;
    }
    private void dfs(TreeNode root,int level){
        if(level==ans.size()) ans.add(root.val);
        if(root.right!=null) dfs(root.right,level+1);
        if(root.left!=null) dfs(root.left,level+1);
    }
}
