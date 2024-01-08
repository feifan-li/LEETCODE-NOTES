package BinaryTree_and_BST.LC2458HeightOfBinaryTreeAfterSubtreeRemovalQueries;
//我们把用DFS遍历树时， 首次进入该节点的时间称为 DFS 序
//https://leetcode.com/problems/height-of-binary-tree-after-subtree-removal-queries/description/
public class Solution2458_dfsOrder {
    public final int MAXN = 100010;
    public int[] dfsOrder = new int[MAXN];
    public int[] size = new int[MAXN];
    public int[] deep = new int[MAXN];
    public int[] dpLeft = new int[MAXN];
    public int[] dpRight = new int[MAXN];
    public int nodes;
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
    public int[] treeQueries(TreeNode root, int[] queries) {
        nodes = 0;
        dfs(root,0);
        //dpLeft[i] : Max(deep[1], ... ,deep[i])
        //dpRight[i]: Max(deep[i], ... ,deep[nodes])
        for(int i=1;i<=nodes;++i){
            dpLeft[i] = Math.max(deep[i],dpLeft[i-1]);
        }
        for(int i=nodes;i>=1;--i){
            dpRight[i] = Math.max(deep[i],dpRight[i+1]);
        }
        //remove a subtree <=> remove a continuous subsequence from dfsOrder
        int m = queries.length;
        int[] ans = new int[m];
        for(int i=0;i<m;++i){
            int id = dfsOrder[queries[i]];
            ans[i] = Math.max(dpLeft[id-1],dpRight[id+size[id]]);
        }
        return ans;
    }
    public void dfs(TreeNode root, int h){
        int i = ++nodes;
        dfsOrder[root.val] = i;
        size[i] = 1;
        deep[i] = h;
        if(root.left!=null) {
            dfs(root.left,h+1);
            size[i] += size[dfsOrder[root.left.val]];
        }
        if(root.right!=null){
            dfs(root.right,h+1);
            size[i] += size[dfsOrder[root.right.val]];
        }
    }
}
