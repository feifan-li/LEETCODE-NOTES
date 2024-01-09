package DynamicProgramming.ArithmeticSlices.LC413ArithmeticSlices_Subarray;

public class Solution413 {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length, ans = 0;
        int[] d = new int[n];//以nums[i]结尾的子数组（>=2个元素）公差
        int[] dp = new int[n];//dp[i]: 以nums[i]结尾的子数组（>=2个元素）个数
        for(int i=1;i<n;++i){
            d[i] = nums[i]-nums[i-1];
            dp[i] += (d[i-1]==d[i]?dp[i-1]+1:1);
            ans += (d[i-1]==d[i]?dp[i-1]:0);
        }
        return ans;
    }
}
