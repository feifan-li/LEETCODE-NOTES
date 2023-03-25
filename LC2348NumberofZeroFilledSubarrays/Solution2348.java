package LC2348NumberofZeroFilledSubarrays;

public class Solution2348 {
    //for an array filled with 0, suppose its length euqals n, then there're 1+...+n subarrays filled with 0
    //so we can solve this problem within one shot
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        long n = 0;
        for(int i=0;i<nums.length;++i){
            if(nums[i]==0) n++;
            else if(nums[i]!=0 && n!=0){
                ans += ((1L+n)*n)>>1;
                n = 0;//reset n=0
            }
        }
        ans+=((1L+n)*n)>>1;
        return ans;
    }
}
