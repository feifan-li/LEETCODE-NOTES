package BFS.LC103BinaryTreeZigZagLevelOrderTraversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution103 {
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if(root==null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean reverseOrder = false;
        while(!q.isEmpty()){
            int size = q.size();
            LinkedList<Integer> list = new LinkedList<>();
            for(int i=0;i<size;++i){
                TreeNode cur = q.poll();
                if(!reverseOrder) list.addLast(cur.val);
                else list.addFirst(cur.val);
                if(cur.left!=null) q.offer(cur.left);
                if(cur.right!=null) q.offer(cur.right);
            }
            ans.add(list);
            reverseOrder = reverseOrder==true?false:true;
        }
        return ans;
    }
}
