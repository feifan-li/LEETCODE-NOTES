package Greedy.LC2551PutMarblesInBags;

import java.util.Arrays;

public class Solution2551 {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        long ans = 0L;
        if(n==k)    return ans;
        //each way of spliting will give score: weights[0] + weights[n-1] + (k-1)pairs' weights
        //the way has max score must have max (k-1) pairs's weights
        //the way has min score must have min (k-1) pairs's weights
        long[] pairs = new long[n-1];
        for(int i=0;i<n-1;++i)  pairs[i] = (long)weights[i]+(long)weights[i+1];
        Arrays.sort(pairs);
        for(int cnt=0;cnt<k-1;++cnt)    ans += (pairs[n-2-cnt]-pairs[cnt]);
        return ans;
    }
}
