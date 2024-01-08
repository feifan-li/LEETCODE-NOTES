package BinaryTree_and_BST.LC105ConstructBinaryTreefromPreorderandInorderTraversal;

import java.util.HashMap;

public class Solution105 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
    //preorder and inorder consist of unique values.
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> inMap = new HashMap<>();//num to index
        for(int i=0;i<inorder.length;++i){
            inMap.put(inorder[i],i);
        }
        return helper(preorder,inorder,0,preorder.length-1,0,inorder.length-1,inMap);
    }
    private TreeNode helper(int[] preorder,int[] inorder,int pl,int pr,int il,int ir,HashMap<Integer,Integer> inMap){
        if(pl>pr || il>ir) return null;
        TreeNode root = new TreeNode(preorder[pl]);
        if(pl==pr) return root;
        int rootIndexInorder = inMap.get(preorder[pl]);
        root.left = helper(preorder,inorder,pl+1,pl+rootIndexInorder-il,il,rootIndexInorder-1,inMap);
        root.right = helper(preorder,inorder,pl+rootIndexInorder-il+1,pr,rootIndexInorder+1,ir,inMap);
        return root;
    }
}
