package DynamicProgramming.LC790DominoTrominoTiling;
// Given an integer n, return the number of ways to tile an 2 x n board.
// Since the answer may be very large, return it modulo 109 + 7
public class Solution790 {
    //dynamic programming
    //dp(i,s): all boards from row 1 to row i-1 are covered, all boards from row i+1 are not covered
    //s = 0: no board of row i is covered after a new titling
    //s = 1: only first board of row i is covered after a new titling
    //s = 2: only second board of row i is covered after a new titling
    //s = 3: first and second boards of row i are both covered after a new titling
    public static int numTilings(int n) {
        final int MOD = 1000000007;
        int[][] dp = new int[n+1][4];
        dp[0][3] = 1;
        for(int i=1;i<=n;++i){
            dp[i][0] = dp[i-1][3]%MOD;
            dp[i][1] = (dp[i-1][0]%MOD+ dp[i-1][2]%MOD) % MOD;
            dp[i][2] = (dp[i-1][0]%MOD + dp[i-1][1]%MOD) % MOD;
            dp[i][3] = (((dp[i-1][0]%MOD + dp[i-1][1]%MOD) % MOD + dp[i-1][2]%MOD) % MOD + dp[i-1][3]%MOD)%MOD;
        }
        return dp[n][3];
    }

    public static void main(String[] args) {
        System.out.println(numTilings(1));
        System.out.println(numTilings(2));
        System.out.println(numTilings(3));
        System.out.println(numTilings(4));
        System.out.println(numTilings(5));
        System.out.println(numTilings(1000));
    }
}
