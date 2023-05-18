package BinaryTree.LC173BinarySearchTreeIterator;

import java.util.Stack;

public class Solution173 {
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
    class BSTIterator {
        public Stack<TreeNode> stack;
        public BSTIterator(TreeNode root) {
            this.stack = new Stack<>();
            helper(root);
        }

        public int next() {
            TreeNode top = stack.pop();
            helper(top.right);
            return top.val;
        }

        public boolean hasNext() {
            return stack.size()>0;
        }

        private void helper(TreeNode root){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
        }
    }
}
