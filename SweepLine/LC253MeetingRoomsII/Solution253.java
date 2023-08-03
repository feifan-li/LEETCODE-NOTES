package SweepLine.LC253MeetingRoomsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//Given an array of meeting time intervals where intervals[i] = [starti, endi],
// return the minimum number of conference rooms required.
public class Solution253 {
    //sweep line
    //min rooms <=> max number of overlapping conferences
    public int minMeetingRooms(int[][] intervals) {
        int[][] list = new int[intervals.length*2][2];
        for(int i=0;i<intervals.length;++i){
            list[i*2][0] = intervals[i][0];
            list[i*2][1] = 1;
            list[i*2+1][0] = intervals[i][1];
            list[i*2+1][1] = -1;
        }
        Arrays.sort(list,(a, b)->(a[0]==b[0]?a[1]-b[1]:a[0]-b[0]));//同一时刻既有开始又有结束则先结束
        int ans = 0,cnt = 0;
        for(int[] p:list){
            cnt += p[1];
            ans = Math.max(ans,cnt);
        }
        return ans;
    }
}
