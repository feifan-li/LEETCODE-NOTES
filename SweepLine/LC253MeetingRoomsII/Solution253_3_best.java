package SweepLine.LC253MeetingRoomsII;

import java.util.Arrays;

public class Solution253_3_best {
    //Tricky Solution
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length,j = 0,rooms = 0;
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i=0;i<n;++i)    start[i] = intervals[i][0];
        for(int i=0;i<n;++i)    end[i]   = intervals[i][1];
        Arrays.sort(start);
        Arrays.sort(end);
        for(int i=0;i<n;++i){
            if(start[i]<end[j]) rooms++;
            else    j++;
        }
        return rooms;
    }
}
