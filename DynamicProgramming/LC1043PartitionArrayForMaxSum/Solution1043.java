package DynamicProgramming.LC1043PartitionArrayForMaxSum;

public class Solution1043 {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        //base case:
        dp[n-1] = arr[n-1];
        for(int i = n-2;i>=0;--i){
            int curMax = arr[i];
            for(int j=i;j<=Math.min(n-1,i+k-1);++j){
                curMax = Math.max(curMax,arr[j]);
                dp[i] = Math.max(dp[i],curMax*(j-i+1)+(j==n-1?0:dp[j+1]));
            }
        }
        return dp[0];
    }
}
