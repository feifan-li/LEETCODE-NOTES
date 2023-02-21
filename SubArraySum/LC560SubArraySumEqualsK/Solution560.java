package SubArraySum.LC560SubArraySumEqualsK;

import java.util.HashMap;

public class Solution560 {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> preSum = new HashMap<>();
        preSum.put(0,1);

        int ans = 0;int sum_i = 0;
        for(int i=0;i<n;++i){
            sum_i+=nums[i];
            int sum_j = sum_i - k;
            if(preSum.containsKey(sum_j)) ans+=preSum.get(sum_j);
            preSum.put(sum_i,preSum.getOrDefault(sum_i,0)+1);
        }

        return ans;
    }
}
