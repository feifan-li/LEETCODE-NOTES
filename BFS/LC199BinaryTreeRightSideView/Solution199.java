package BFS.LC199BinaryTreeRightSideView;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if(root==null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;++i){
                TreeNode cur = q.poll();
                if(i==0) ans.add(cur.val);
                if(cur.right!=null) q.offer(cur.right);
                if(cur.left!=null) q.offer(cur.left);
            }
        }
        return ans;
    }
}
