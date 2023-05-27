package DynamicProgramming.LC877StoneGame;

import java.util.Arrays;

public class Solution877_2 {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        if(n==2)    return true;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;++i){
            Arrays.fill(dp[i],Integer.MIN_VALUE);
            dp[i][i] = piles[i];
        }
        return f(dp,piles,0,n-1)>0;
    }
    private int f(int[][] dp,int[] piles,int i,int j){
        if(dp[i][j]!=Integer.MIN_VALUE){
            return dp[i][j];
        }
        if(i+1==j){
            dp[i][j] = Math.max(piles[i],piles[j]) - Math.min(piles[i],piles[j]);
            return dp[i][j];
        }
        dp[i][j] = Math.max(piles[i]-f(dp,piles,i+1,j),piles[j]-f(dp,piles,i,j-1));
        return dp[i][j];
    }
}
