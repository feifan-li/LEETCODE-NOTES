package CumulativeSum.LC560SubArraySumEqualsK;

import java.util.HashMap;

public class Solution560 {
    //普通前缀和方法：O(N^2)
    public static int subarraySum1(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n+1];
//        sum[0] = 0;
        for(int i=1;i<=n;++i){
            sum[i] = sum[i-1]+nums[i-1];
        }
        //sum[i] = nums[0]+...+nums[i-1];  前i位的和
        //sum[i] - sum[j] = nums[j]+...+nums[i-1], (i>j)
        int ans = 0;
        for(int i=1;i<=n;++i){
            for(int j=0;j<i;++j){
                if(sum[i] - sum[j] == k) ans++;
            }
        }
        return ans;
    }
    //优化：O(N)
    public static int subarraySum2(int[] nums, int k){
        int n = nums.length;
        //前缀和（nums[0]+...nums[i]），出现次数
        HashMap<Integer,Integer> preSum = new HashMap<>();
        preSum.put(0,1);
        int ans = 0;
        int sum_i = 0;// sum of first i elements of nums[]
        for(int i=0;i<n;++i){
            sum_i += nums[i];
            int sum_j = sum_i - k;
            if(preSum.containsKey(sum_j)) ans+=preSum.get(sum_j);
            preSum.put(sum_i,preSum.getOrDefault(sum_i,0)+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum1(new int[]{1,1,1},2));
        System.out.println(subarraySum1(new int[]{1,2,3},3));
        System.out.println(subarraySum2(new int[]{1,1,1},2));
        System.out.println(subarraySum2(new int[]{1,2,3},3));
    }
}
