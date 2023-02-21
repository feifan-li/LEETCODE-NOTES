package DynamicProgramming.LC62UniquePaths;

import java.util.Arrays;

public class Solution62 {
    public static int uniquePaths(int m, int n) {
        if(m==1||n==1) return 1;
        int[][] dp = new int[m][n];
        //base case:
        Arrays.fill(dp[m-1],1);
        for(int i=0;i<m;++i){
            dp[i][n-1] = 1;
        }
        for(int i=m-2;i>=0;--i){
            for(int j=n-2;j>=0;--j){
                dp[i][j] = dp[i][j+1] + dp[i+1][j];
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {

    }
}
