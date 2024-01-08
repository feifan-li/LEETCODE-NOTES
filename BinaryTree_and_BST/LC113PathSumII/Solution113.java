package BinaryTree_and_BST.LC113PathSumII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution113 {
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
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null) return ans;
        LinkedList<Integer> path = new LinkedList<>();
        dfs(root,targetSum,path);
        return ans;
    }
    private void dfs(TreeNode root,int sum,LinkedList<Integer> path){
        path.add(root.val);
        if(root.left==null && root.right==null){
            if(root.val==sum) {
                ans.add(new LinkedList<Integer>(path));
                path.removeLast();
                return;
            }
        }
        if(root.left!=null) dfs(root.left,sum-root.val,path);
        if(root.right!=null) dfs(root.right,sum-root.val,path);
        path.removeLast();
    }
}
