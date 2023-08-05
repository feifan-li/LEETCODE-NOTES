package PrefixSum.LC437PathSumIII;

import java.util.HashMap;

public class Solution437 {
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
    public HashMap<Long,Integer> map = new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
        dfs(root,targetSum,0L);
        return ans;
    }
    private void dfs(TreeNode root,int target,long cur){
        if(root==null) return;
        cur += root.val;
        if(cur==target) ans++;
        ans += map.getOrDefault(cur-target,0);//starting from ancestor's prefix sum
        map.put(cur,map.getOrDefault(cur,0)+1);
        if(root.left!=null) dfs(root.left,target,cur);
        if(root.right!=null) dfs(root.right,target,cur);
        //backtrack
        map.put(cur,map.get(cur)-1);
    }
}
