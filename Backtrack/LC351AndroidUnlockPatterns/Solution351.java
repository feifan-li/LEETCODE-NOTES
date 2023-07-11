package Backtrack.LC351AndroidUnlockPatterns;

public class Solution351 {
    public int numberOfPatterns(int m, int n) {
        int[][] pass = new int[][]{
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,2,0,0,0,4,0,5},
                {0,0,0,0,0,0,0,0,5,0},
                {0,2,0,0,0,0,0,5,0,6},
                {0,0,0,0,0,0,5,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,5,0,0,0,0,0},
                {0,4,0,5,0,0,0,0,0,8},
                {0,0,5,0,0,0,0,0,0,0},
                {0,5,0,6,0,0,0,8,0,0},
        };//pass[i][j]: i to j pass through pass[i][j]
        int ans = 0;
        for(int i=m;i<=n;++i){
            ans += dfs(1,1,pass,new boolean[10],i)*4;
            ans += dfs(2,1,pass,new boolean[10],i)*4;
            ans += dfs(5,1,pass,new boolean[10],i);
        }
        return ans;
    }
    public int dfs(int start, int d, int[][] pass, boolean[] visited, int n){
        if(d==n)    return 1;
        visited[start] = true;
        int res = 0;
        for(int i=1;i<=9;++i){
            if(!visited[i] && (pass[start][i]==0 || visited[pass[start][i]])){
                res += dfs(i,d+1,pass,visited,n);
            }
        }
        visited[start]=false;
        return res;
    }
}
