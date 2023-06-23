package DynamicProgramming.LC1027LongestArithmeticSubsequence;

import java.util.HashMap;

public class Solution1027 {
    public int longestArithSeqLength(int[] nums) {
        int ans = 0;
        HashMap<Integer,Integer>[] dp = new HashMap[nums.length];//dp[i].get(d):length of longest arithmetic sequence whose diff is d ending with i
        for(int i=0;i<nums.length;++i){
            dp[i] = new HashMap<Integer,Integer>();
            for(int j=0;j<i;++j){
                int d = nums[i] - nums[j];
                int length = dp[j].getOrDefault(d,1)+1;
                dp[i].put(d,length);
                ans = Math.max(ans,length);
            }
        }
        return ans;
    }
}
