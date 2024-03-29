package SweepLine.Intervals.LC435NonOverlappingIntervals;

import java.util.Arrays;

public class Solution435_2 {
    public static int eraseOverlapIntervals2(int[][] intervals) {
        Arrays.sort(intervals,(a, b)->a[1]-b[1]);
        int count = 0, end = Integer.MIN_VALUE;
        for(int[] i:intervals){
            if(end<=i[0]) end = i[1];
            else count++;//此时end不变，删掉了较晚结束的, 为后续interval留下更多空间
        }
        return count;
    }
}
