package DynamicProgramming.LC472ConcatenatedWords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution472 {
    HashSet<Long> set = new HashSet<>();
    int p = 137, offset = 128;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans = new ArrayList<>();
        for(String w:words){
            long hash = getHash(w);
            set.add(hash);
        }
        for(String w:words){
            if(isConcatenated(w)) ans.add(w);
        }
        return ans;
    }
    public long getHash(String s){
        long hash = 0;
        for(char c:s.toCharArray()){
            hash = hash*p + (c-'a')+offset;
        }
        return hash;
    }
    private boolean isConcatenated(String s){
        int n = s.length();
        int[] dp = new int[n+1];//dp[i]:s[1]...s[i] consists of a max num of dp[i] sub-words
        Arrays.fill(dp,-1);
        dp[0]=0;
        for(int i=0;i<=n;++i){
            if(dp[i]==-1) continue;
            long curHash = 0;
            for(int j=i+1;j<=n;++j){
                curHash = curHash*p + (s.charAt(j-1)-'a') + offset;
                if(set.contains(curHash)) dp[j] = Math.max(dp[j],dp[i]+1);
            }
            if(dp[n]>1) return true;
        }
        return false;
    }
}
