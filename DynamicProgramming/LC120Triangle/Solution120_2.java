package DynamicProgramming.LC120Triangle;

import java.util.List;

public class Solution120_2 {
    //bottom-up
    public int minimumTotal(List<List<Integer>> t) {
        int n = t.size();
        int[] dp = new int[n];
        for(int i=0;i<n;++i)    dp[i] = t.get(n-1).get(i);
        for(int row=n-2;row>=0;--row){
            for(int col=0;col<=row;++col){
                dp[col] = t.get(row).get(col) + Math.min(dp[col],dp[col+1]);
            }
        }
        return dp[0];
    }
}
