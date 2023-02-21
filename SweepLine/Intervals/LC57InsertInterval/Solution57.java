package SweepLine.Intervals.LC57InsertInterval;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution57 {
    //sweep line
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<>();
        int i=0,start = newInterval[0],end = newInterval[1];
        while(i<intervals.length && intervals[i][1]<start){//时间还没到插入点
            res.add(intervals[i++]);
        }
        while(i<intervals.length && intervals[i][0]<=end){//overlap:intervals[i][1]>=start , intervals[i][0]<=end
            start = Math.min(start,intervals[i][0]);
            end = Math.max(end,intervals[i++][1]);
        }
        res.add(new int[]{start,end});//insert newInterval
        while(i<intervals.length){// now intervals[i][0] > end
            res.add(intervals[i++]);
        }
        return res.toArray(new int[][]{});

    }

    public static void main(String[] args) {
        int[][] test1 = insert(new int[][]{{1,3},{6,9}},new int[]{2,5});
        for(int[] t:test1) {System.out.print(Arrays.toString(t));}
        System.out.println();
        int[][] test2 = insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}},new int[]{4,8});
        for(int[] t:test2) {System.out.print(Arrays.toString(t));}
    }
}
