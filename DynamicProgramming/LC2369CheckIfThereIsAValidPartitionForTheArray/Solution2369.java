package DynamicProgramming.LC2369CheckIfThereIsAValidPartitionForTheArray;

public class Solution2369 {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        if(n<=1)    return false;
        if(n>=2)    dp[1] = (nums[0]==nums[1]);
        if(n>=3)    dp[2] = ((nums[0]==nums[1] && nums[1]==nums[2])||(nums[0]==nums[1]-1 && nums[1]==nums[2]-1));
        for(int i=3;i<=nums.length-1;++i){
            if(nums[i-1]==nums[i] && dp[i-2]){
                dp[i] = true;
            }else if((nums[i-2]==nums[i-1] && nums[i-1]==nums[i])
                    ||(nums[i-2]==nums[i-1]-1 && nums[i-1]==nums[i]-1)){
                dp[i] = dp[i-3];
            }
        }
        return dp[n-1];
    }
}
