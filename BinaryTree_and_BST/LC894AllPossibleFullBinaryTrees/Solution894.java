package BinaryTree.LC894AllPossibleFullBinaryTrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution894 {
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
    HashMap<Integer, List<TreeNode>> memo = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int n) {
        if(memo.containsKey(n)) return memo.get(n);
        if(n==0 || n==2){
            memo.put(n,new ArrayList<TreeNode>());
            return new ArrayList<TreeNode>();
        }
        List<TreeNode> ans = new ArrayList<>();
        if(n==1){
            ans.add(new TreeNode(0));
            memo.put(n,ans);
            return memo.get(n);
        }
        for(int cnt = 1;cnt<=n-2;++cnt){
            List<TreeNode> leftFBT = allPossibleFBT(cnt);
            List<TreeNode> rightFBT = allPossibleFBT(n-1-cnt);
            if(leftFBT.size()==0 || rightFBT.size()==0) continue;
            for(TreeNode l:leftFBT){
                for(TreeNode r:rightFBT)    ans.add(new TreeNode(0,l,r));
            }
        }
        memo.put(n,ans);
        return ans;
    }
}
