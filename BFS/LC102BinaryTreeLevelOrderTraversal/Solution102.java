package BFS.LC102BinaryTreeLevelOrderTraversal;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution102 {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if(root==null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> list = new LinkedList<>();
            int size = q.size();
            for(int i=0;i<size;++i){
                TreeNode cur = q.poll();
                list.add(cur.val);
                if(cur.left!=null) q.add(cur.left);
                if(cur.right!=null) q.add(cur.right);
            }
            ans.add(list);
        }
        return ans;
    }
}
