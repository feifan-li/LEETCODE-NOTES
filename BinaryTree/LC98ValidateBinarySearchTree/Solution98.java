package BinaryTree.LC98ValidateBinarySearchTree;

public class Solution98 {
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
    public class Info{
        public boolean isBST;
        public int max;
        public int min;
        public Info(boolean i, int max,int min){
            this.isBST = i;
            this.max = max;
            this.min = min;
        }
    }
    public Info process(TreeNode x){
        if(x==null) {
            return null;
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        int max = x.val;
        if(leftInfo!=null){
            max = Math.max(max,leftInfo.max);
        }
        if(rightInfo!=null){
            max = Math.max(max, rightInfo.max);
        }

        int min = x.val;
        if(leftInfo!=null){
            min = Math.min(min,leftInfo.min);
        }
        if(rightInfo!=null){
            min = Math.min(min, rightInfo.min);
        }

        boolean isBST = true;
        if(leftInfo!=null && !leftInfo.isBST) isBST = false;
        if(rightInfo!=null && !rightInfo.isBST) isBST = false;
        if(leftInfo!=null && leftInfo.max >= x.val) isBST = false;
        if(rightInfo!=null && rightInfo.min<=x.val) isBST = false;
        return new Info(isBST,max,min);
    }
    public boolean isValidBST(TreeNode head){
        if(head==null) return true;
        return process(head).isBST;
    }
}
