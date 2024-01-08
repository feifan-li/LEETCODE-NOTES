package BinaryTree_and_BST.LC1372LongestZigZagPathInABinaryTree;

public class Solution1372 {
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
    public int longestZigZag(TreeNode root) {
        dfs(root);
        return ans;
    }
    public int[] dfs(TreeNode root){
        int[] cur = new int[2];
        //curZigZag[0]: left, curZigZag[1]: right
        if(root.left==null && root.right==null){
            return cur;
        }
        if(root.left!=null){
            int[] left = dfs(root.left);
            cur[0] = left[1]+1;
        }
        if(root.right!=null){
            int[] right = dfs(root.right);
            cur[1] = right[0]+1;
        }
        ans = Math.max(ans,Math.max(cur[0],cur[1]));
        return cur;
    }
}
