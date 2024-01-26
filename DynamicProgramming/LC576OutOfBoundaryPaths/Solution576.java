package DynamicProgramming.LC576OutOfBoundaryPaths;

public class Solution576 {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if(maxMove==0)  return 0;
        int MOD = 1_000_000_007;
        long[][][] dp = new long[m+2][n+2][2];
        //base cases:
        for(int j=1;j<=n;++j){
            dp[1][j][0] += 1;
            dp[m][j][0] += 1;
        }
        for(int i=1;i<=m;++i){
            dp[i][1][0] += 1;
            dp[i][n][0] += 1;
        }
        long ans = dp[startRow+1][startColumn+1][0];
        for(int x = 1;x < maxMove;++x){
            for(int i=1;i<=m;++i){
                for(int j=1;j<=n;++j){
                    dp[i][j][x%2] = dp[i-1][j][(x-1)%2] + dp[i][j-1][(x-1)%2]
                            + dp[i+1][j][(x-1)%2] + dp[i][j+1][(x-1)%2];
                    dp[i][j][x%2] %= MOD;
                }
            }
            ans = (ans + dp[startRow+1][startColumn+1][x%2])%MOD;
        }
        return (int)(ans%MOD);
    }
}
