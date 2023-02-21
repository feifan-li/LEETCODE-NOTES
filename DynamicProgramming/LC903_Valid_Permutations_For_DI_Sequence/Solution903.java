package DynamicProgramming.LC903_Valid_Permutations_For_DI_Sequence;

public class Solution903 {
    //dynamic programming
    public static int numPermsDISequence(String s){
        final int MOD = 1000000007;
        int n = s.length();
        int[][] dp = new int[n+2][n+2];
        //need to permute n+1 integers, indexed from 1 to n+1
        //dp[i][j]: valid num of ways for filling first i integers
        // when ith integer has the rank j
        // (note that integers are unique and valued from 0 to n for all positions),
        //base case:
        dp[1][1] = 1;
        for(int i=2;i<=n+1;++i){
            for(int j=1;j<=i;++j){
                if(s.charAt(i-2)=='D'){
                    for(int k=j;k<=i-1;++k){
                        dp[i][j] = (dp[i][j]+dp[i-1][k]) % MOD;
                    }
                }else{
                    for(int k=1;k<=j-1;++k){
                        dp[i][j] = (dp[i][j]+dp[i-1][k]) % MOD;
                    }
                }
            }
        }
        //dp[n+1][rank], enumerate rank
        int ans = 0;
        for(int rank = 1;rank<=n+1;++rank){
            ans = (ans + dp[n+1][rank]) % MOD;
        }
        return ans % MOD;
    }

    public static void main(String[] args) {
        System.out.println(numPermsDISequence("DID"));
        System.out.println(numPermsDISequence("D"));
    }
}
