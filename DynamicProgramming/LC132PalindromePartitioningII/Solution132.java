package DynamicProgramming.LC132PalindromePartitioningII;

public class Solution132 {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        //dp(i): min cuts needed for a palindrome partitioning of s[0]...s[i]
        boolean[][] isPalindrome = new boolean[n][n];
        //isPalindrome[j][i] = true if s[j]...s[i] is palindrome
        for(int i=0;i<n;++i){
            int min = i;
            for(int j=0;j<=i;++j){
                if(s.charAt(j)==s.charAt(i) && (i-j<2 || isPalindrome[j+1][i-1])){
                    isPalindrome[j][i] = true;
                    min = j==0?0:Math.min(min,dp[j-1]+1);
                }
            }
            dp[i] = min;
        }
        return dp[n-1];
    }
}
