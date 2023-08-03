package DivideAndConquer.LC654MaximumBinaryTree;

public class Solution654 {
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dc(nums,0,nums.length-1);
    }
    public TreeNode dc(int[] nums,int l,int r){
        if(l>r) return null;
        if(l==r)    return new TreeNode(nums[l]);
        int max = -1,max_idx = -1;
        for(int i=l;i<=r;++i){
            if(nums[i]>max){
                max = nums[i];
                max_idx = i;
            }
        }
        return new TreeNode(max,dc(nums,l,max_idx-1),dc(nums,max_idx+1,r));
    }
}
