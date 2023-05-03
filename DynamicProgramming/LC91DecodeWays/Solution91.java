package DynamicProgramming.LC91DecodeWays;

public class Solution91 {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = s.charAt(0)=='0'?0:1;
        for(int i=2;i<dp.length;++i){
            char l = s.charAt(i-1);
            char h = s.charAt(i-2);
            if(l!='0') dp[i] += dp[i-1];
            if(h!='0' && (h-'0')*10+(l-'0')>=1 && (h-'0')*10+(l-'0')<=26){
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];
    }
}
