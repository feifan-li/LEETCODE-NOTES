package BFS.LC107BinaryTreeLevelOrderTraversalII;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution107 {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        if(root==null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new LinkedList<>();
            for(int i=0;i<size;++i){
                TreeNode cur = q.poll();
                list.add(cur.val);
                if(cur.left!=null) q.offer(cur.left);
                if(cur.right!=null) q.offer(cur.right);
            }
            ans.addFirst(list);
        }
        return ans;
    }
}
