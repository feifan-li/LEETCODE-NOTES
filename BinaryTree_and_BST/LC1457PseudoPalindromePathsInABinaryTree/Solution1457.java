package BinaryTree_and_BST.LC1457PseudoPalindromePathsInABinaryTree;

public class Solution1457 {
    public int paths = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        dfs(root,new int[10]);
        return paths;
    }
    public void dfs(TreeNode root, int[] freq){
        freq[root.val]++;
        if(root.left==null && root.right==null){
            int odd = 0;
            for(int num:freq){
                if(num%2==1)    odd++;
            }
            paths += (odd>1?0:1);
        }
        if(root.left!=null){
            dfs(root.left,freq);
        }
        if(root.right!=null){
            dfs(root.right,freq);
        }
        freq[root.val]--;
    }
}
