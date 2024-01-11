package BinaryTree_and_BST.LC2385AmountOfTimeForBinaryTreeToBeInfected;

public class Solution2385 {
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
    public int maxTime = 0;
    public int amountOfTime(TreeNode root, int start) {
        dfs(root,start);
        return maxTime;
    }
    public int dfs(TreeNode root,int target){
        /** 返回非负值表示该子树的深度，
         返回负值表示该子树包含target节点，
         负值的绝对值表示target节点与该子树root的距离*/
        int depth = 0;
        if(root==null)  return depth;
        int leftDepth = dfs(root.left,target);
        int rightDepth = dfs(root.right,target);
        if(root.val==target){
            maxTime = Math.max(leftDepth,rightDepth);
            depth = -1;
        }else if(leftDepth>=0 && rightDepth>=0){
            depth = Math.max(leftDepth,rightDepth)+1;
        }else{
            int time = Math.abs(leftDepth)+Math.abs(rightDepth);
            maxTime = Math.max(maxTime,time);
            depth = Math.min(leftDepth,rightDepth)-1;
        }
        return depth;
    }
}
