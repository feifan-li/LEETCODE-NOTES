package LC2261KDivisibleElementsSubarrays;

import java.util.HashSet;

public class Solution2261 {
    public int countDistinct(int[] nums, int k, int p) {
        int[] count = new int[nums.length];
        count[0] = nums[0]%p==0?1:0;
        for(int i=1;i<nums.length;++i)  count[i] = count[i-1] + (nums[i]%p==0?1:0);
        HashSet<String> set = new HashSet<>();
        int ans = 0;
        for(int i=0;i<nums.length;++i){
            StringBuilder sb = new StringBuilder();
            for(int j=i;j<nums.length;++j){
                sb.append(nums[j]).append(",");
                if(!set.contains(sb.toString()) && (count[j]-(i>0?count[i-1]:0))<=k){
                    set.add(sb.toString());
                    ans++;
                }else if((count[j]-(i>0?count[i-1]:0))>k){
                    break;
                }
            }
        }
        return ans;
    }
}
