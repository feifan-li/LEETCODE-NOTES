package BinaryTree_and_BST.LC652FindDuplicateSubTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution652 {
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
    List<TreeNode> ans = new LinkedList<>();
    Map<String,Integer> map = new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return ans;
    }
    private String dfs(TreeNode root){
        if(root==null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append("(");
        String left = dfs(root.left);
        String right = dfs(root.right);
        sb.append(left).append(")").append("(").append(right).append(")");
        String s = sb.toString();
        map.put(s,map.getOrDefault(s,0)+1);
        if(map.get(s)==2) ans.add(root);//we found a duplicate Node first time
        return s;
    }
}
