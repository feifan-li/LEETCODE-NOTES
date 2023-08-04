package Backtrack.LC377CombinationSumIV;

import java.util.HashMap;

public class Solution377 {
    public HashMap<Integer,Integer> memo = new HashMap<>();
    public int combinationSum4(int[] nums, int target) {
        memo.put(0,1);
        return helper(nums,target);
    }
    public int helper(int[] nums,int target){
        if(memo.containsKey(target))    return memo.get(target);
        if(target<0)   return 0;
        int ans = 0;
        for(int i=0;i<nums.length;++i)  ans += target-nums[i]>=0?helper(nums,target-nums[i]):0;
        memo.put(target,ans);
        return ans;
    }
}
