package DynamicProgramming.LC918MaxSumCircularSubarray;

public class Solution918 {
    public static int maxSubarraySumCircular(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int n = nums.length;
        if(n==1) return nums[0];
        //(1)circle数组
        int[] circle = new int[n*2];
        for(int i=0;i<n;++i){
            circle[i] = nums[i];
            circle[i+n] = nums[i];
        }
        //(2)前缀和数组
        int[] sum = new int[n*2];
        sum[0] = circle[0];
        for(int i=1;i<sum.length;++i){
            sum[i] = sum[i-1]+circle[i];
        }
        //(3)query数组:从后向前遍历nums[],query[i] = sum of max-sum subarray start with index >= i , end with index n-1
        int[] query = new int[n];
        query[n-1] = nums[n-1];
        for(int i=n-2;i>=0;i--){
            query[i] = Math.max(query[i+1],nums[i]+sum[n-1]-sum[i]);
        }
        //(4)dp
        int dp[] = new int[2*n];
        dp[0] = circle[0];
        ans = Math.max(ans,dp[0]);
        for(int i=1;i<n;++i){
            if(circle[i]+dp[i-1]>circle[i]){
                dp[i] = circle[i]+dp[i-1];
            }else{
                dp[i] = circle[i];
            }
            ans = Math.max(ans,dp[i]);
        }
        for(int i=n;i<circle.length-1;++i){
            dp[i] = Math.max(dp[i-n],query[i-n+1]+sum[i]-sum[n-1]);
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxSubarraySumCircular(new int[]{1,-2,3,-2}));
        System.out.println(maxSubarraySumCircular(new int[]{5,-3,5}));
        System.out.println(maxSubarraySumCircular(new int[]{-3,-2,-3}));
    }
}
