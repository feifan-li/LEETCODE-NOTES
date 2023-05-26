package DynamicProgramming.LC1140StoneGameII;

import java.util.Arrays;

public class Solution1140 {
    public final int ALICE = 0;
    public final int BOB = 1;
    public int stoneGameII(int[] piles) {
        int[][][] dp = new int[2][piles.length+1][piles.length+1];
        for(int role = 0;role<=1;++role){
            for(int i=0;i<=piles.length;++i){
                Arrays.fill(dp[role][i],-1);
            }
        }
        return f(piles,dp,ALICE,0,1);//Alice starts first with M = 1
    }
    private int f(int[] piles,int[][][] dp,int role,int i,int M){
        if(i>=piles.length) return 0;
        if(dp[role][i][M]!=-1)  return dp[role][i][M];
        int stones = 0;
        int res = role==ALICE?Integer.MIN_VALUE:Integer.MAX_VALUE;
        for(int X = 1;X<=Math.min(2*M,piles.length-i);++X){
            stones += piles[i+X-1];
            if(role==ALICE) res = Math.max(res,stones+f(piles,dp,BOB,i+X,Math.max(M,X)));
            else if(role==BOB) res = Math.min(res,f(piles,dp,ALICE,i+X,Math.max(M,X)));
        }
        dp[role][i][M] = res;
        return dp[role][i][M];
    }
}
