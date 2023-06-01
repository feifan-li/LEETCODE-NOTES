package DynamicProgramming.LC1872StoneGameVIII;

public class Solution1872 {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int[] sum = new int[n];
        sum[0] = stones[0];
        for(int i=1;i<n;++i)    sum[i] = stones[i]+sum[i-1];
        int[] dp = new int[n];//dp[i]: max difference of current player if remove all stones with index <=k, k>=i
        dp[n-1] = sum[n-1];//the player can only remove all stones
        for(int i=n-2;i>0;--i)  dp[i] = Math.max(dp[i+1],sum[i]-dp[i+1]);//choose k>i or k=i
        return dp[1];
    }
}
