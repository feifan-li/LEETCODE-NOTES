package LC313SuperUglyNumber;

import java.util.Arrays;

public class Solution313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] nums = new long[n];
        int[] ids = new int[primes.length];
        Arrays.fill(nums,Integer.MAX_VALUE);
        nums[0] = 1L;
        for(int i=1;i<n;++i){
            for(int j=0;j<primes.length;++j){
                nums[i] = Math.min(nums[i],nums[ids[j]]*primes[j]);
            }
            for(int j=0;j<primes.length;++j){
                if(nums[i] == nums[ids[j]]*primes[j]) ids[j] += 1;
            }
        }
        return (int)nums[n-1];
    }
}
