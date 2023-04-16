package DynamicProgramming.LC1639NumofWaysToFormATargetStringGivenADictionary;

public class Solution1639 {
    public int numWays(String[] words, String target) {
        final int MOD = 1000000007;
        int k = words[0].length();
        int m = target.length();
        int[][] dict = new int[k][26];//(column,char)
        for(String w:words){
            for(int i=0;i<k;++i){
                dict[i][w.charAt(i)-'a'] += 1;
            }
        }
        long[][] dp = new long[m+1][k+1];//dp[i][j]: use first j col to form first i chars
        dp[0][0] = 1;
        for(int i = 1;i <= m+1;++i){
            for(int j = 1;j <= k;++j){
                if(i<m+1) dp[i][j] = (dp[i][j] + (dp[i-1][j-1]*dict[j-1][target.charAt(i-1)-'a']));
                //form first i-1 chars, use first j-1 or j col
                dp[i-1][j] = (dp[i-1][j] + dp[i-1][j-1])%MOD;
            }
        }
        return (int)dp[m][k]%MOD;
    }
}
