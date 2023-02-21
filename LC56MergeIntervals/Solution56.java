package LC56MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution56 {
    //sweep line
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a, b)->a[0]-b[0]);//by start time increasingly
        ArrayList<int[]> res = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int[] itv:intervals){
            if(itv[0]<=end){//overlap
                end = Math.max(itv[1],end);
            }else{
                res.add(new int[]{start,end});
                start = itv[0];
                end = itv[1];
            }
        }
        res.add(new int[]{start,end});
        return res.toArray(new int[][]{});
    }

    public static void main(String[] args) {

    }
}
