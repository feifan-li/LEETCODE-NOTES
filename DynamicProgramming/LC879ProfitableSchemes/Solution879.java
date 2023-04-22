package DynamicProgramming.LC879ProfitableSchemes;

public class Solution879 {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        //crime的所有组合
        final int MOD = (int)1e9+7;
        int crimes = group.length;
        int[][][] dp = new int[crimes+1][n+1][minProfit+1];
        //dp[i][j][k]: ways to choose from first i crimes, with j members, generate at least k profit
        //base case:
        dp[0][0][0] = 1;
        for(int i=1;i<=crimes;++i){
            for(int j=0;j<=n;++j){
                for(int k=0;k<=minProfit;++k){
                    if(j<group[i-1]){//不选择这一crime
                        dp[i][j][k] = dp[i-1][j][k];
                    }else{//选择或不选择这一crime
                        dp[i][j][k] = (dp[i-1][j][k] + dp[i-1][j-group[i-1]][Math.max(0,k-profit[i-1])])%MOD;
                    }
                }
            }
        }
        int ans = 0;
        for(int j=0;j<=n;++j)   ans = (ans+dp[crimes][j][minProfit])%MOD;
        return ans;
    }
}
