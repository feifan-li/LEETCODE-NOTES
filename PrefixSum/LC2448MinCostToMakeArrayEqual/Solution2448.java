package PrefixSum.LC2448MinCostToMakeArrayEqual;

import java.util.Arrays;

public class Solution2448 {
    public long minCost(int[] nums, int[] cost) {
        //注意对防止Long型溢出的处理
        int n = nums.length;
        int[][] arr = new int[n][2];
        for(int i=0;i<n;++i){
            arr[i][0] = nums[i];
            arr[i][1] = cost[i];
        }
        Arrays.sort(arr,(a,b)->(a[0]-b[0]));//sorted by nums
        long sum = 0;
        long[] costSum = new long[n];
        costSum[0] = arr[0][1];
        for(int i=1;i<n;++i){
            costSum[i] = costSum[i-1] + arr[i][1];
            sum += 1L*arr[i][1]*(arr[i][0] - arr[0][0]);
        }
        long ans = sum;//sum: total cost to make all elements in `nums` equal to nums[0]
        for(int i=0;i<n-1;++i){
            long delta = arr[i+1][0] - arr[i][0];
            //elements at or after i+1 previously used operations more than they need, need to give back
            sum -= delta*(costSum[n-1]-costSum[i]);
            //elements before i+1 need more operations than they've used
            sum += delta*costSum[i];
            //sum: total cost to make all elements in `nums` equal to nums[i+1]
            ans = Math.min(ans,sum);
        }
        return ans;
    }
}
