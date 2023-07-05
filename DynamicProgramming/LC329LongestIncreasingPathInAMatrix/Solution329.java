package DynamicProgramming.LC329LongestIncreasingPathInAMatrix;

import java.util.Arrays;

public class Solution329 {
    public boolean[][] visited;
    public int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int[][] dp;
    public int max = 1;
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        visited = new boolean[m][n];
        dp = new int[m][n];//length of longest path starting with (i,j)
        for(int i=0;i<m;++i)    Arrays.fill(dp[i],1);
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(!visited[i][j])  dfs(matrix,i,j);
            }
        }
        return max;
    }
    public void dfs(int[][] matrix,int i,int j){
        int m = matrix.length;
        int n = matrix[0].length;
        visited[i][j] = true;
        for(int[] dir:dirs){
            int row = i+dir[0], col = j+dir[1];
            if(row>=0 && col>=0 && row<m && col<n && matrix[row][col]>matrix[i][j]){
                if(!visited[row][col])  dfs(matrix,row,col);
                dp[i][j] = Math.max(dp[i][j],dp[row][col]+1);
                max = Math.max(max,dp[i][j]);
            }
        }
    }
}
