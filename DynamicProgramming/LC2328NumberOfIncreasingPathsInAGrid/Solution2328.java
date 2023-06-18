package DynamicProgramming.LC2328NumberOfIncreasingPathsInAGrid;

public class Solution2328 {
    public int MOD = (int)(1e9+7);
    public int[][] dp;
    public int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int countPaths(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        dp = new int[m][n];//dp[i][j]: number of strictly increasing paths ending with grid[i][j]
        int ans = 0;
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                ans = (ans + dfs(grid,i,j))%MOD;
            }
        }
        return ans;
    }
    public int dfs(int[][] grid,int i,int j){
        if(dp[i][j] != 0)   return dp[i][j];
        int ans = 1;
        for(int[] d:dirs){
            int row = i+d[0], col = j+d[1];
            if(row>=0 && row<grid.length && col>=0 && col<grid[0].length && grid[row][col] < grid[i][j]){
                ans = (ans + dfs(grid,row,col))%MOD;
            }
        }
        dp[i][j] = ans;
        return ans;
    }
}
