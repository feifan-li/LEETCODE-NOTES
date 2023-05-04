package DynamicProgramming.LC650_2KeysKeyboard;

import java.util.Arrays;

public class Solution650 {
    public int minSteps(int n) {
        //dp:dp[i] is the min number of ops to get 'A' i times
        int[] dp = new int[n+1];
        Arrays.fill(dp,9999);
        dp[1] = 0;
        for(int i=1;i<=n;++i){
            for(int k=2;k*i<=n;++k){
                dp[k*i] = Math.min(dp[k*i],dp[i]+k);
            }
        }
        return dp[n];
    }
}
