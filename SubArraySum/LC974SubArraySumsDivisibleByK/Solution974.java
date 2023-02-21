package SubArraySum.LC974SubArraySumsDivisibleByK;

import java.util.HashMap;

public class Solution974 {
    //nums[i] + ... + nums[j] = sum[j]-sum[i-1]
    //(sum[j]-sum[i-1])%k == 0 <==> sum[j]%k == sum[i-1]%k
    public static int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int sum_i = 0;
        HashMap<Integer,Integer> record = new HashMap<>();//preSum%k -> counts
        record.put(0,1);
        for(int i=0;i<n;++i){
            sum_i += nums[i];
            int mod = (sum_i%k + k)%k;// -1 % 5 = -1 -> =4
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
