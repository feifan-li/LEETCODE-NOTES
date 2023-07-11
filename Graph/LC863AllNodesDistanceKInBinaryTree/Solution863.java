package Graph.LC863AllNodesDistanceKInBinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution863 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for(int i=0;i<501;++i)  g.add(new ArrayList<Integer>());
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur.left!=null){
                g.get(cur.val).add(cur.left.val);
                g.get(cur.left.val).add(cur.val);
                q.offer(cur.left);
            }
            if(cur.right!=null){
                g.get(cur.val).add(cur.right.val);
                g.get(cur.right.val).add(cur.val);
                q.offer(cur.right);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[501];
        queue.offer(target.val);
        visited[target.val] = true;
        int d = 0;
        while(!queue.isEmpty()){
            int sz = queue.size();
            for(int cnt = 0;cnt < sz;++cnt){
                int cur = queue.poll();
                if(d==k){
                    ans.add(cur);
                    continue;
                }
                for(int neighbour:g.get(cur)){
                    if(!visited[neighbour]){
                        visited[neighbour] = true;
                        queue.offer(neighbour);
                    }
                }
            }
            if(d==k)    break;
            d++;
        }
        return ans;
    }
}
