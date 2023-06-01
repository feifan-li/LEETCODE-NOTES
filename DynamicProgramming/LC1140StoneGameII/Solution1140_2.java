package DynamicProgramming.LC1140StoneGameII;

import java.util.Arrays;

public class Solution1140_2 {
    public int stoneGameII(int[] piles) {
        int[][] dp = new int[piles.length+1][piles.length+1];
        int sum = 0;
        for(int i=0;i<=piles.length;++i){
            Arrays.fill(dp[i],Integer.MIN_VALUE);
            if(i<piles.length)  sum += piles[i];
        }
        return (f(piles,dp,0,1)+sum)/2;
    }
    private int f(int[] piles,int[][] dp,int i,int M){
        if(i>=piles.length) return 0;
        if(dp[i][M]!=Integer.MIN_VALUE)  return dp[i][M];
        int stones = 0;
        for(int X = 1;X<=Math.min(2*M,piles.length-i);++X){
            stones += piles[i+X-1];
            dp[i][M] = Math.max(dp[i][M],stones-f(piles,dp,i+X,Math.max(M,X)));
        }
        return dp[i][M];
    }
}
