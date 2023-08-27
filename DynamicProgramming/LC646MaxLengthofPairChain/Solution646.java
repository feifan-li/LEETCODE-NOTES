package DynamicProgramming.LC646MaxLengthofPairChain;

import java.util.Arrays;

public class Solution646 {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a, b)->(a[0]==b[0]?a[1]-b[1]:a[0]-b[0]));
        int[] dp = new int[pairs.length];
        //base case:
        dp[0] = 1;
        int max = dp[0];
        for(int i=1;i<pairs.length;++i){
            int j=i-1;
            while(j>=0){
                if(pairs[j][1]<pairs[i][0]) break;
                j--;
            }
            dp[i] = (j==-1?0:dp[j]) + 1;
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
