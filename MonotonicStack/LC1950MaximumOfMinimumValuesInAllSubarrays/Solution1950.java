package MonotonicStack.LC1950MaximumOfMinimumValuesInAllSubarrays;

public class Solution1950 {
    public int[] findMaximums(int[] nums) {
        int[] ans = new int[nums.length];
        int[] s = new int[nums.length];
        int top = -1;
        for(int R=0;R<nums.length;++R){
            while(top>=0 && nums[R]<=nums[s[top]]){
                int i = s[top--];
                int L = top>=0?s[top]:-1;
                int len = R-L-1;
                ans[len-1] = Math.max(ans[len-1],nums[i]);
            }
            s[++top] = R;
        }
        while(top>=0){
            int i = s[top--];
            int L = top>=0?s[top]:-1;
            int len = nums.length-L-1;
            ans[len-1] = Math.max(ans[len-1],nums[i]);
        }
        //ans[i]:index 0~i should have value at least ans[i]
        for(int i=ans.length-2;i>=0;--i)    ans[i] = Math.max(ans[i],ans[i+1]);
        return ans;
    }
}
