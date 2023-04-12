package MonotonicStack.LC1856MaxSubarrayMINProduct;

import java.util.Stack;

public class Solution1856 {
    final int MOD = 1000000000+7;
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        long max = (long)-1;
        //mono-stack
        Stack<Integer> stack = new Stack<>();
        long[] sum = new long[nums.length];
        sum[0] = nums[0];
        for(int i=1;i<n;++i){
            sum[i] = nums[i]+sum[i-1];
        }
        for(int i=0;i<n;++i){
            while(!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
                int j = stack.pop();
                max = Math.max(max,(stack.isEmpty()?sum[i-1]:sum[i-1]-sum[stack.peek()])*nums[j]);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int j = stack.pop();
            max = Math.max(max,(stack.isEmpty()?sum[n-1]:sum[n-1]-sum[stack.peek()])*nums[j]);
        }
        return (int)(max%MOD);
    }
}
