package DynamicProgramming.ArithmeticSlices.LC446ArithmeticSlicesII_Subsequences;

import java.util.HashMap;

public class Solution446 {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int ans = 0;
        //dp[i][d]: 以nums[i]结尾的，公差为d的，子序列(元素数>=2)的数量
        HashMap<Long,Integer>[] dp = new HashMap[n];
        for(int i=0;i<n;++i){
            dp[i] = new HashMap<Long,Integer>();
            for(int j=i-1;j>=0;--j){
                long d = (long)nums[i]-(long)nums[j];
                int prev = dp[j].getOrDefault(d,0);
                dp[i].put(d,dp[i].getOrDefault(d,0)+prev+1);
                ans += prev;
            }
        }
        return ans;
    }
}
