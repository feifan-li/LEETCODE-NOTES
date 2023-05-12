package DynamicProgramming.LC2140SolvingQuestionsWithBrainpower;

public class Solution2140 {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        dp[n-1] = questions[n-1][0];
        for(int i=n-2;i>=0;--i){
            dp[i] = Math.max(questions[i][0]+((i+questions[i][1]+1>n-1)?0:dp[i+questions[i][1]+1]),dp[i+1]);
        }
        return dp[0];
    }
}
