package DynamicProgramming.LC413ArithmeticSlices;

public class Solution413 {

        public int numberOfArithmeticSlices(int[] nums) {
            int n = nums.length, ans = 0;
            int[][] dp = new int[n][4001];//dp[i][d]: 公差为d，以nums[i]结尾的子数组（>=2个元素）个数
            for(int i=1;i<n;++i){
                int d = nums[i]-nums[i-1]+2001;
                dp[i][d] += dp[i-1][d]+1;
                ans += dp[i-1][d];
            }
            return ans;
        }

}
