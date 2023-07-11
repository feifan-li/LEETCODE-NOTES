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
        int[] res1 = dfs(1,1,pass,new boolean[10],m,n);
        int[] res2 = dfs(2,1,pass,new boolean[10],m,n);
        int[] res5 = dfs(5,1,pass,new boolean[10],m,n);
        for(int i=m;i<=n;++i)   ans += res1[i]*4+res2[i]*4+res5[i];
        return ans;
    }
    public int[] dfs(int start, int d, int[][] pass, boolean[] visited, int m,int n){
        int[] res = new int[10];
        if(d>=m && d<=n)    res[d]++;
        if(d==n)    return res;
        visited[start] = true;
        for(int i=1;i<=9;++i){
            if(!visited[i] && (pass[start][i]==0 || visited[pass[start][i]])){
                int[] iRes = dfs(i,d+1,pass,visited,m,n);
                for(int j=0;j<=9;++j)   res[j] += iRes[j];
            }
        }
        visited[start]=false;
        return res;
    }
}
