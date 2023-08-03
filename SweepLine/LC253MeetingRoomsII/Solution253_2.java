package SweepLine.LC253MeetingRoomsII;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution253_2 {
    //Priority Queue
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals,(a, b)->(a[0]-b[0]));
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b)->(a[1]-b[1]));
        heap.offer(intervals[0]);
        for(int i=1;i<intervals.length;++i){
            int[] cur = heap.poll();
            if(cur[1]<=intervals[i][0]) cur[1] = intervals[i][1];
            else heap.offer(intervals[i]);
            heap.offer(cur);
        }
        return heap.size();
    }
}
