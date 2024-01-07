package DynamicProgramming.LC1235;

import java.util.Arrays;

public class Solution1235 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        //sort jobs by start time
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for(int i=0;i<n;++i){
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs,(a, b)->(a[0]-b[0]));
        int[][] dp = new int[n][2];
        //base cases:
        dp[n-1][0] = 0;
        dp[n-1][1] = jobs[n-1][2];
        for(int i=n-2;i>=0;--i){
            dp[i][0] = Math.max(dp[i+1][0],dp[i+1][1]);
            int j = searchLeftMostGreaterOrEqual(i+1,n-1,jobs,jobs[i][1]);
            dp[i][1] = jobs[i][2];
            if(j<n) dp[i][1] += Math.max(dp[j][0],dp[j][1]);
        }
        return Math.max(dp[0][0],dp[0][1]);
    }
    public int searchLeftMostGreaterOrEqual(int start,int end,int[][] jobs,int target){
        int l = start, r = end;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(jobs[mid][0]<target) l = mid+1;
            else                    r = mid-1;
        }
        return l;
    }
}
