package Greedy.LC274HIndex;

import java.util.Arrays;

public class Solution274 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;++i){
            ans = Math.max(ans,Math.min(n-i,citations[i]));
        }
        return ans;
    }
}
