package DynamicProgramming.LongestIncreasingSubsequence.LC300LongestIncreasingSubsequnce;

public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];//a strictly increasing seq of length i+1 ending with dp[i]
        int right = 0;
        for(int i=0;i<n;++i){
            int val = nums[i];
            int id = searchLeftMostGreaterOrEqual(dp,0,right,val);
            if(id==right) right++;
            dp[id] = val;
        }
        return right;
    }
    private int searchLeftMostGreaterOrEqual(int[] dp,int left,int right,int k){
        //[left,right)
        while(left<right){
            int mid = left + (right-left)/2;
            if(dp[mid]<k){
                left = mid+1;
            }else{//dp[mid]>=k
                right = mid;
            }
        }
        return left;
    }
}
