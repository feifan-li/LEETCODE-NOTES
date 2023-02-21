package SweepLine.LC253MeetingRoomsII;

import java.util.ArrayList;
import java.util.Collections;

//Given an array of meeting time intervals where intervals[i] = [starti, endi],
// return the minimum number of conference rooms required.
public class Solution253 {
    //sweep line
    //(number of airplanes in the sky)
    //min rooms <=> max number of conferences hoding at the same time
    public int minMeetingRooms(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList<>();
        for(int[] intv:intervals){
            list.add(new int[]{intv[0],1});
            list.add(new int[]{intv[1],-1});
        }
        Collections.sort(list,(a, b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        int ans = 0,cnt = 0;
        for(int i=0;i<list.size();++i){
            int[] p = list.get(i);
            cnt += p[1];
            ans = Math.max(ans,cnt);
        }
        return ans;
    }
}
