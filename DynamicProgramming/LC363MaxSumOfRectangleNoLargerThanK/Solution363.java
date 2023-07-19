package DynamicProgramming.LC363MaxSumOfRectangleNoLargerThanK;

import java.util.TreeSet;

public class Solution363 {
    public int res = Integer.MIN_VALUE;
    public int maxSubarray(int[] nums){
        int max = Integer.MIN_VALUE, cur = 0;
        for(int i=0;i<nums.length;++i){
            cur = Math.max(0,cur+nums[i]);
            max = Math.max(max,cur);
        }
        return max;
    }
    public void maxSubarrayNoLargerThan(int[] nums,int k,int curSum){
        int preprocessingRes = maxSubarray(nums);
        if(preprocessingRes <= k){
            res = Math.max(res,preprocessingRes);
            return;
        }
        TreeSet<Integer> sum = new TreeSet<>();
        sum.add(0);
        for(int num:nums){
            curSum += num;
            Integer x = sum.ceiling(curSum-k); // >= curSum-k 的最小值
            if(x!=null)    res = Math.max(res,curSum - x);
            if(res==k)  return;
            sum.add(curSum);
        }
    }
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        for(int startRow=0;startRow<m;++startRow){
            int[] nums = new int[n];
            for(int i=startRow;i<m;++i){
                for(int j=0;j<n;++j)    nums[j] += matrix[i][j];
                maxSubarrayNoLargerThan(nums,k,0);
                if(res==k)  return k;
            }
        }
        return res;
    }
}
