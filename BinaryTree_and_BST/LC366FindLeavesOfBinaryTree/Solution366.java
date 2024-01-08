package BinaryTree_and_BST.LC366FindLeavesOfBinaryTree;

import java.util.ArrayList;
import java.util.List;

public class Solution366 {

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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res,root);
        return res;
    }
    public int dfs(List<List<Integer>> res,TreeNode root){
        if(root==null) return -1;
        int leftLevel = dfs(res,root.left);
        int rightLevel = dfs(res,root.right);
        int rootLevel = Math.max(leftLevel,rightLevel)+1;
        if(res.size()==rootLevel){
            res.add(new ArrayList<Integer>());
        }
        res.get(rootLevel).add(root.val);
        return rootLevel;
    }

}
