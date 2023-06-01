package LC_Stone_Game_Series.LC1690StoneGameVII;

import java.util.Arrays;

public class Solution1690 {
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[] sum = new int[n];
        sum[0] = stones[0];
        for(int i=1;i<n;++i)    sum[i] = stones[i] + sum[i-1];
        int[][] dp = new int[n][n];
        for(int i=0;i<n;++i){
            Arrays.fill(dp[i],Integer.MIN_VALUE);
            dp[i][i] = 0;
            if(i+1<n)   dp[i][i+1] = Math.max(stones[i],stones[i+1]);
        }
        return f(stones,sum,dp,0,n-1);
    }
    public int f(int[] stones,int[] sum,int[][] dp,int i,int j){
        if(dp[i][j]!=Integer.MIN_VALUE) return dp[i][j];
        dp[i][j] = Math.max(sum[j]-sum[i]-f(stones,sum,dp,i+1,j),sum[j-1]-(i-1>=0?sum[i-1]:0)-f(stones,sum,dp,i,j-1));
        return dp[i][j];
    }
}
