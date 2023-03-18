package BFS.LC958CheckCompletenessOfABinaryTree;

import java.util.LinkedList;

public class Solution958 {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int v) {
            val = v;
        }
    }
    public static boolean isCompleteTree1(TreeNode head){
        if(head==null) return true;
        LinkedList<TreeNode> queue = new LinkedList<>();
        //是否遇到过左右不双全的节点
        boolean leaf  = false;
        TreeNode l = null;
        TreeNode r = null;
        queue.add(head);
        while(!queue.isEmpty()){
            head = queue.poll();
            l = head.left;
            r = head.right;
            if((l==null && r!=null)//每次遍历到一个节点，都查看有没有违反条件1或2
                    || (leaf && (l!=null || r!=null))){ //如果遇到了左右孩子不双全的节点之后，又发现当前节点不是叶子节点
                return false;
            }
            if(l!=null) queue.add(l);
            if(r!=null) queue.add(r);
            if(l==null || r==null) leaf = true;// Note: ||
        }
        return true;
    }
}
