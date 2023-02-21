package MonotonicStack.LC2297JumpGameVIII;

import java.util.HashMap;
import java.util.Stack;

public class Solution2297 {
    public long minCost(int[] nums, int[] costs) {
        HashMap<Integer,int[]> nextGreaterOrEqual = new HashMap<>();
        HashMap<Integer,int[]> nextSmaller = new HashMap<>();
        Stack<int[]> monoDecStack = new Stack<>();
        Stack<int[]> monoIncStack = new Stack<>();
        for(int i=nums.length-1;i>=0;--i){
            while(!monoDecStack.isEmpty() && monoDecStack.peek()[1]<nums[i]){
                monoDecStack.pop();
            }
            nextGreaterOrEqual.put(i,(monoDecStack.isEmpty() ? new int[]{-1,-1} : monoDecStack.peek()));
            monoDecStack.push(new int[]{i,nums[i]});
            while(!monoIncStack.isEmpty() && monoIncStack.peek()[1]>=nums[i]){
                monoIncStack.pop();
            }
            nextSmaller.put(i,(monoIncStack.isEmpty() ? new int[]{-1,-1} : monoIncStack.peek()));
            monoIncStack.push(new int[]{i,nums[i]});
        }
        int n = nums.length;
        long[] dp = new long[n];
        dp[n-1] = (long)costs[n-1];
        for(int i=n-2;i>=0;--i){
            if(nextGreaterOrEqual.get(i)[0]==-1){
                int tmp = nextSmaller.get(i)[0];
                dp[i] = (long) costs[i]+dp[tmp];
            }else if(nextSmaller.get(i)[0]==-1){
                int tmp = nextGreaterOrEqual.get(i)[0];
                dp[i] = (long) costs[i]+dp[tmp];
            }else{
                int tmp1 = nextSmaller.get(i)[0];
                int tmp2 = nextGreaterOrEqual.get(i)[0];
                dp[i] = (long) costs[i] + Math.min(dp[tmp1],dp[tmp2]);
            }
        }
        return dp[0]-costs[0];

    }

    public static void main(String[] args) {

    }
}
