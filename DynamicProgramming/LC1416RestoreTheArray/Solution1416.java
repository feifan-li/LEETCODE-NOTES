package DynamicProgramming.LC1416RestoreTheArray;

public class Solution1416 {
    public int numberOfArrays(String s, int k) {
        final int MOD = (int)1e9+7;
        String ks = k+"";
        int klen = ks.length();
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;dp[1] = 1;
        if(s.charAt(0)=='0') return 0;
        for(int l=2;l<=n;++l){
            int h = l;
            while(h>=1){
                if(l-h+1>klen) break;
                if(s.charAt(h-1)!='0' && (l-h+1>klen || Long.parseLong(s.substring(h-1,l))>k)){
                    break;
                }else if(s.charAt(h-1)!='0' && Long.parseLong(s.substring(h-1,l))<=k){
                    dp[l] = (dp[l]+dp[h-1])%MOD;
                }
                h--;
            }
        }
        return dp[n];
    }
}
