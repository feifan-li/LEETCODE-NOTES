package DynamicProgramming.LC97InterleavingString;

public class Solution97 {
    public static boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if(s3.length()!=m+n) return false;
        if(m==0) return s3.equals(s2);
        if(n==0) return s3.equals(s1);
        //dp[i][j]: s1(0,...,i-1) interleaving with s2(0,...,j-1) can form s3(0,i+j-1) or not
        boolean[][] dp = new boolean[m+1][n+1];
        //base case:
        dp[0][0] = true;
        for(int i=1;i<=n;++i){
            dp[0][i] = s2.charAt(i-1)==s3.charAt(i-1) && dp[0][i-1];
        }
        for(int i=1;i<=m;++i){
            dp[i][0] = s1.charAt(i-1)==s3.charAt(i-1) && dp[i-1][0];
        }
        for(int i=1;i<=m;++i){
            for(int j=1;j<=n;++j){
                if(s1.charAt(i-1)!=s3.charAt(i+j-1) && s2.charAt(j-1)!=s3.charAt(i+j-1)){
                    dp[i][j] = false;
                    continue;
                }
                if(s1.charAt(i-1)==s3.charAt(i+j-1)){
                    dp[i][j] = dp[i][j] || dp[i-1][j];
                }
                if(s2.charAt(j-1)==s3.charAt(i+j-1)){
                    dp[i][j] = dp[i][j] || dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(isInterleave("a","","a"));
    }
}
