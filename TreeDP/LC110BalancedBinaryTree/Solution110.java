package TreeDP.LC110BalancedBinaryTree;

public class Solution110 {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int v) {
            val = v;
        }
    }
    public static class Info{
        public boolean isBalanced;
        public int height;
        public Info(boolean i, int h){
            isBalanced = i;
            height = h;
        }
    }
    public static Info process(TreeNode x){
        if(x == null){
            return new Info(true,0);//空树也是平衡的
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        boolean isBalanced = true;
        if(!leftInfo.isBalanced) isBalanced = false;
        if(!rightInfo.isBalanced) isBalanced = false;
        if(Math.abs(leftInfo.height-rightInfo.height)>1) isBalanced = false;
        int height = Math.max(leftInfo.height,rightInfo.height)+1;
        return new Info(isBalanced,height);
    }
    public static boolean isBalanced(TreeNode head){
        return process(head).isBalanced;
    }
}
