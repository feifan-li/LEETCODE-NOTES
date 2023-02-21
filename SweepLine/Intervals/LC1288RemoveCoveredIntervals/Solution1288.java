package SweepLine.Intervals.LC1288RemoveCoveredIntervals;

import java.util.Arrays;

//The interval [a, b) is covered by the interval [c, d) if and only if c <= a and b <= d
//Return the number of remaining intervals.
public class Solution1288 {
    public static int removeCoveredIntervals(int[][] intervals) {
        //interval can only be covered by its previous interval
        Arrays.sort(intervals,(a,b)->a[0]==b[0]? b[1]-a[1]:a[0]-b[0]);
        int count = 0,end = 0;
        for(int[] i:intervals){
            if(end<i[1]){
                end = i[1];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
