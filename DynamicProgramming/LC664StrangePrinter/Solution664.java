package DynamicProgramming.LC664StrangePrinter;

public class Solution664 {
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];//dp[l][r]: # of ops to make r-l+1 s[r] to become s[l,...,r]
        for(int len = 1;len<=n;++len){
            for(int l = 0;l<=n-len;l++){
                int r = l+len-1, i = -1;
                for(int j=l;j<r;++j){
                    if(i==-1 && s.charAt(j)!=s.charAt(r)){
                        i = j;
                        break;
                    }
                }
                if(i==-1)   dp[l][r] = 0;
                else{
                    dp[l][r] = n;
                    for(int j=i;j<r;++j)    dp[l][r] = Math.min(dp[l][r],1+dp[i][j]+dp[j+1][r]);
                }
            }
        }
        return dp[0][n-1]+1;
    }
}
