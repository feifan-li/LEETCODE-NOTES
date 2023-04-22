package BinaryTree.LC662MaxWidthOfBinaryTree;

import java.util.HashMap;
import java.util.Map;

public class Solution662 {
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
    Map<Integer, Integer> levelMin = new HashMap<Integer, Integer>();
    int ans;
    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 0, 1);
        return ans;
    }
    public void dfs(TreeNode node, int depth, int index) {
        if (node == null) {return;}
        levelMin.putIfAbsent(depth, index); // 每一层最先访问到的节点会是最左边的节点，即每一层编号的最小值
        ans = Math.max(ans,index - levelMin.get(depth) + 1);
        dfs(node.left, depth + 1, (index<<1)-1);
        dfs(node.right, depth + 1, (index<<1));
    }
}
