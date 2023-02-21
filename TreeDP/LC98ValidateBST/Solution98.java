package TreeDP.LC98ValidateBST;

public class Solution98 {
    public static class TreeNode {
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
    //每一颗子树的左树都比自己小，右树都比自己大
    //给一颗树的根x，判断是否是BST
    //1)x左树是BST
    //2)x右树是BST
    //3)x左树上的最大值<x.val
    //4)x右树上的最小值>x.val
    public static class Info{
        public boolean isBST;
        public int max;
        public int min;
        public Info(boolean i, int max,int min){
            this.isBST = i;
            this.max = max;
            this.min = min;
        }
    }
    public static Info process(TreeNode x){
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
    public static boolean isValidBST(TreeNode head){
        if(head==null) return true;
        return process(head).isBST;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n2.left = n1;
        n2.right = n3;
        System.out.println(isValidBST(n2));

    }
}
