package LC228SummaryRanges;

import java.util.ArrayList;
import java.util.List;

public class Solution228 {
    public List<String> summaryRanges(int[] nums) {
        int left = 0, right = 0;
        List<String> ans = new ArrayList<>();
        while(left<nums.length){
            while(right+1<nums.length && nums[right] == nums[right+1]-1){
                right++;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(nums[left]);
            if(left!=right) sb.append("->").append(nums[right]);
            ans.add(sb.toString());
            left = right+1;
            right = right+1;
        }
        return ans;
    }
}

