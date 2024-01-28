package DynamicProgramming.LC629KInversePairsArray;

public class Solution629 {
    public int kInversePairs(int n, int k) {
        int MOD = 1_000_000_007;
        //dp[i][j]: kInversePairs(i,0) + ... + kInversePairs(i,j)
        int[][] dp = new int[n+1][k+1];
        //base cases:
        for(int i=1;i<=n;++i)   dp[i][0] = 1;
        for(int i=1;i<=n;++i){
            for(int j=1;j<=k;++j){
                //kInversePairs(i,j) is:
                int p = Math.min(j,i-1);
                int cur = (MOD+dp[i-1][j] - (j-p-1>=0?dp[i-1][j-p-1]:0))%MOD;
                dp[i][j] = (dp[i][j-1] + cur)%MOD;
            }
        }
        return k==0?1:(MOD+dp[n][k]-dp[n][k-1])%MOD;
    }
}
