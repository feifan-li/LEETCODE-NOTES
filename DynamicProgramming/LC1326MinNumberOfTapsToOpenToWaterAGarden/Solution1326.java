package DynamicProgramming.LC1326MinNumberOfTapsToOpenToWaterAGarden;

import java.util.Arrays;

public class Solution1326 {
    public int minTaps(int n, int[] ranges) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,n*2);
        dp[0] = 0;
        for(int j=0;j<=n;++j){
            int l = Math.max(0,j-ranges[j]);
            int r = Math.min(n,j+ranges[j]);
            for(int i=l;i<=r;i++){
                dp[i] = Math.min(dp[i],dp[l]+1);
            }
        }
        return dp[n]==2*n?-1:dp[n];
    }
}
