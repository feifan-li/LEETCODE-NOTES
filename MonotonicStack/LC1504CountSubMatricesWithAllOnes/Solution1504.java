package MonotonicStack.LC1504CountSubMatricesWithAllOnes;

public class Solution1504 {
    public int ans = 0;
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        countMatOfOnes(mat[0]);
        for(int i=1;i<m;++i){
            for(int j=0;j<n;++j){
                if(mat[i][j]==1){
                    mat[i][j] += mat[i-1][j];
                }
            }
            countMatOfOnes(mat[i]);
        }
        return ans;
    }
    private void countMatOfOnes(int[] heights){
        int[] stack = new int[heights.length];
        int top = -1;
        for(int i=0;i<heights.length;++i){
            while(top!=-1 && heights[i]<=heights[stack[top]]){
                int h = heights[stack[top--]];
                if(h==heights[i]) continue;
                int leftLess = top==-1?-1:stack[top];
                int matOfOnes = (h-Math.max(heights[i],(leftLess==-1?0:heights[leftLess])))*((i-leftLess-1)*(i-leftLess)/2);
                ans += matOfOnes;
            }
            stack[++top] = i;
        }
        while(top!=-1){
            int h = heights[stack[top--]];
            int leftLess = top==-1?-1:stack[top];
            int matOfOnes = (h-Math.max(0,(leftLess==-1?0:heights[leftLess])))*((heights.length-leftLess-1)*(heights.length-leftLess)/2);
            ans += matOfOnes;
        }
        return;
    }
}
