package Greedy.LC435NonOverlappingIntervals;

import java.util.Arrays;
import java.util.Comparator;

public class Solution435 {
    public static int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        // sort by end_i increasingly
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[1] - b[1];
            }
        });
        int count = 1;
        int end = intervals[0][1];
        for(int[] interval:intervals){
            int start = interval[0];
            if(start>=end){
                count++;
                end = interval[1];
            }
        }
        return n-count;
    }

    public static void main(String[] args) {

    }
}
