package LC128LongestConsecutiveSquence;

import java.util.HashSet;

public class Solution128 {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length==0) return 0;
        int ans = 1;
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums)   set.add(num);
        for(int i=0;i<nums.length;++i){
            int low = nums[i]-1;
            int high = nums[i]+1;
            while(set.contains(low))    set.remove(low--);
            while(set.contains(high))   set.remove(high++);
            ans = Math.max(ans,high-low-1);
        }
        return ans;
    }
}
