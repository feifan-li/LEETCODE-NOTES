package LC230KthSmallestElementInABST;

import java.util.Stack;

public class Solution230 {
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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<>();
        while(k!=0){
            while(root!=null){
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if(--k==0)  return root.val;
            root = root.right;
        }
        return -1;
    }
}
