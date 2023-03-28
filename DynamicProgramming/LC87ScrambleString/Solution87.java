package DynamicProgramming.LC87ScrambleString;

public class Solution87 {
    public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2)) return true;
        int n = s1.length();
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int[] count = new int[26];
        for(int i=0;i<n;++i){
            count[str1[i]-'a']++;
            count[str2[i]-'a']--;
        }
        for(int i:count){
            if(i!=0) return false;
        }
        boolean[][][] dp = new boolean[n][n][n+1];//dp[i][j][len]:isScramble(s1从i开始长为len的子串，s2从j开始长为len的子串)
        //len = 1
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                dp[i][j][1] = str1[i]==str2[j];
            }
        }
        for(int len=2;len<=n;++len){
            //start from i, end at i+len-1, i+len-1<=n-1
            for(int i=0;i<=n-len;++i){
                for(int j=0;j<=n-len;++j){
                    for(int sublen = 1;sublen<len;++sublen){
                        if(dp[i][j][sublen] && dp[i+sublen][j+sublen][len-sublen]) dp[i][j][len] = true;
                        else if(dp[i][j+len-sublen][sublen] && dp[i+sublen][j][len-sublen]) dp[i][j][len] = true;
                    }
                }
            }
        }
        return dp[0][0][n];
    }
}
