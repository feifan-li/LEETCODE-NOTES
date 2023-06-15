package BFS.LC1161MaxLevelSumOfABinaryTree;
import java.util.Queue;
import java.util.LinkedList;
public class Solution1161 {
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
    public int maxLevelSum(TreeNode root) {
        long max = Integer.MIN_VALUE;
        int ans = 0,level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int sz = q.size();
            long levelSum = 0;
            level++;
            for(int cnt = 0;cnt<sz;++cnt){
                TreeNode u = q.poll();
                levelSum += u.val;
                if(u.left!=null)    q.offer(u.left);
                if(u.right!=null)   q.offer(u.right);
            }
            if(levelSum>max){
                max = levelSum;
                ans = level;
            }
        }
        return ans;
    }
}
