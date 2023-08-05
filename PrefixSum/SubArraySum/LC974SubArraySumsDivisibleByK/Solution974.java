package PrefixSum.SubArraySum.LC974SubArraySumsDivisibleByK;

import java.util.HashMap;

public class Solution974 {
    //nums[i] + ... + nums[j] = sum[j]-sum[i-1]
    //(sum[j]-sum[i-1])%k == 0 <==> sum[j]%k == sum[i-1]%k
    /**Input:an integer array nums, and an integer k
     * Output: count of subarrays that are divisible by k
     * Need to clarify:
     *  1) what is the length of input array?
     *  2) what should the output be if the input array is empty or does not contain any non-empty array that is divisible by k?
     * Solution:
     *  we need to know the sum of an array if we want to check whether it is divisible by k, intuitively we can first get the sum of nums[0,...i], i=0,...nums.len-1
     *  in O(n) time.
     *  However, to check the sum of every subarray in a brute-force manner will still cost O(n^2) time, to further optimize,
     *  we want to check the number of subarrays ending at one index and are divisible by k in O(1) time, so that the overall time complexity will be O(n)
     *  Note that if a%k = b%k, then (a-b)%k = 0, where a and b can be the subarray's sum, therefore we can iterate through every index i, and let a be the sum of nums[0,...,i],
     *  then we just need to check the number of b's , namely the number of subarrays s[0,...,j], j<i, whose sum mod k equals a mod k. This can be easily done by maintaining a HashMap that behaves as such a counter
     **/
    public static int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int sum_i = 0;
        HashMap<Integer,Integer> record = new HashMap<>();//preSum%k -> counts
        record.put(0,1);//base case
        for(int i=0;i<n;++i){
            sum_i += nums[i];
            int mod = (sum_i%k + k)%k;// e.g.: -1 % 5 = -1, (-1 % 5 + 5)%5 =4
            if(record.containsKey(mod)) ans += record.get(mod);
            record.put(mod,record.getOrDefault(mod,0)+1);
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(subarraysDivByK(new int[]{4,5,0,-2,-3,1},5));
        System.out.println(subarraysDivByK(new int[]{5},9));
    }
}
