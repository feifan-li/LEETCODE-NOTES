package DynamicProgramming.LC2218MaxValofKCoinsFromPiles;

import java.util.List;

public class Solution2218 {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();//n piles
        int[][] dp = new int[n+1][k+1];//dp[i][j]:max val of j coins from first i piles
        for(int i=1;i<=n;++i){
            List<Integer> pile = piles.get(i-1);
            for(int coins = 1;coins <= k;++coins){
                int curPileVal = 0;
                dp[i][coins] = Math.max(dp[i][coins],dp[i-1][coins]);
                for(int curPileCoins = 1;curPileCoins <= Math.min(coins,pile.size());++curPileCoins){
                    curPileVal += pile.get(curPileCoins-1);
                    dp[i][coins] = Math.max(dp[i][coins],dp[i-1][coins-curPileCoins]+curPileVal);
                }
            }
        }
        return dp[n][k];
    }
}
