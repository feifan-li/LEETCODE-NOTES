package Backtrack.DFS.LC200NumberOfIslands;

public class Solution200 {
    public int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length, ans = 0;
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(grid[i][j]=='1'){
                    ans++;
                    dfs(grid,i,j,m,n);
                }
            }
        }
        return ans;
    }
    public void dfs(char[][] grid,int i,int j,int m,int n){
        grid[i][j] = '0';
        for(int[] dir:dirs){
            if(i+dir[0]>=0 && i+dir[0]<m && j+dir[1]>=0 && j+dir[1]<n && grid[i+dir[0]][j+dir[1]]=='1'){
                dfs(grid,i+dir[0],j+dir[1],m,n);
            }
        }
    }
}
