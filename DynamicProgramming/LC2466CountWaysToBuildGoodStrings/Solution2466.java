package DynamicProgramming.LC2466CountWaysToBuildGoodStrings;

public class Solution2466 {
    public int countGoodStrings(int low, int high, int zero, int one) {
        final int MOD = 1000000007;
        long ans = 0;
        int[] dp = new int[high+1];
        dp[0] = 1;
        for(int i=1;i<=high;++i){
            if(i>=zero) dp[i] += dp[i-zero];
            if(i>=one) dp[i] += dp[i-one];
            dp[i] %= MOD;
        }
        for(int i=low;i<=high;++i)  ans += dp[i];
        return (int)(ans%MOD);
    }
}
