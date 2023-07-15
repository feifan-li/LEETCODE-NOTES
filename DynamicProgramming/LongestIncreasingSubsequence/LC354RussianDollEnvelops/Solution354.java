package DynamicProgramming.LongestIncreasingSubsequence.LC354RussianDollEnvelops;

import java.util.Arrays;

public class Solution354 {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes,(a, b)->(a[0]==b[0]?b[1]-a[1]:a[0]-b[0]));
        int[] lis = new int[n];//dp[0]~dp[i] is the longest strictly increasing subsequnce ending with dp[i]
        int lisLen = 0;
        for(int i=0;i<n;++i){
            int id = searchLeftMostGreaterOrEqual(lis,0,lisLen,envelopes[i][1]);
            if(id==lisLen)  lisLen++;
            lis[id] = envelopes[i][1];
        }
        return lisLen;
    }
    public int searchLeftMostGreaterOrEqual(int[] nums,int left,int right,int val){
        while(left<right){
            int mid = left + (right-left)/2;
            if(nums[mid]<val)   left = mid+1;
            else right = mid;
        }
        return left;
    }
}
