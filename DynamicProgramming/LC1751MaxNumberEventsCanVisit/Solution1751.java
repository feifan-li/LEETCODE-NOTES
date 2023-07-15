package DynamicProgramming.LC1751MaxNumberEventsCanVisit;

import java.util.Arrays;

public class Solution1751 {
    public int[][] memo;
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events,(a, b)->(a[0]-b[0]));
        memo = new int[events.length][k+1];
        for(int[] row:memo)   Arrays.fill(row,-1);
        return dp(events,0,k,0);
    }
    public int dp(int[][] events,int i,int cnt,int end){
        if(i==events.length || cnt==0)    return 0;
        if(events[i][0]<=end)   return dp(events,i+1,cnt,end);//conflict case
        if(memo[i][cnt]==-1)    memo[i][cnt] = Math.max(events[i][2]+dp(events,i+1,cnt-1,events[i][1]), dp(events,i+1,cnt,end));
        return memo[i][cnt];
    }
}
