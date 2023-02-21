package SweepLine.LC252MeetingRooms;

import java.util.Arrays;

//Given an array of meeting time intervals where intervals[i] = [starti, endi],
// determine if a person could attend all meetings.
public class Solution252 {
    public static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals,(a, b)->a[0]-b[0]);
        for(int i=0;i<intervals.length-1;++i){
            if(intervals[i][1] >intervals[i+1][0]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canAttendMeetings(new int[][]{{0,30},{5,10},{15,20}}));
        System.out.println(canAttendMeetings(new int[][]{{7,10},{2,4}}));
    }
}
