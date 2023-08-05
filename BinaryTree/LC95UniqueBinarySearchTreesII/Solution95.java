package BinaryTree.LC95UniqueBinarySearchTreesII;

import java.util.ArrayList;
import java.util.List;

public class Solution95 {
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
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(0,n-1);
    }
    public List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> sublist = new ArrayList<TreeNode>();
        if(start>end)   sublist.add(null);
        else if(start==end) sublist.add(new TreeNode(start+1));
        else{
            for (int i=start;i<=end;i++){
                List<TreeNode> leftnodes = generateTrees(start,i-1);
                List<TreeNode> rightnodes = generateTrees(i+1,end);
                for(TreeNode lnode:leftnodes){
                    for(TreeNode rnode:rightnodes)  sublist.add(new TreeNode(i+1,lnode,rnode));
                }
            }
        }
        return sublist;
    }
}
