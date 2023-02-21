package DynamicProgramming.LC926FlipStringToMonotoneIncreasing;

public class Solution926 {
    /** A binary string is monotone increasing if it consists of some number of 0's (possibly none),
     * followed by some number of 1's (also possibly none).**/
    //dynamic programming
    //dp[i][0]: min number of flips to make s[i]=0 and s[0,...,i] mono
    //dp[i][1]: min number of flips to make s[i]=1 and s[0,...,i] mono
    public static int minFlipsMonoIncr(String s) {
        int dp_i_0 = s.charAt(0)=='0'?0:1;
        int dp_i_1 = s.charAt(0)=='1'?0:1;
        for(int i=1;i<s.length();++i){
            int dp_i_0_new = dp_i_0;
            int dp_i_1_new = Math.min(dp_i_0,dp_i_1);
            dp_i_0_new += (s.charAt(i)=='0'?0:1);
            dp_i_1_new += (s.charAt(i)=='1'?0:1);
            dp_i_0 = dp_i_0_new;
            dp_i_1 = dp_i_1_new;
        }
        return Math.min(dp_i_0,dp_i_1);
    }

    public static void main(String[] args) {
        System.out.println(minFlipsMonoIncr("00110"));
        System.out.println(minFlipsMonoIncr("010110"));
        System.out.println(minFlipsMonoIncr("00011000"));
    }
}
