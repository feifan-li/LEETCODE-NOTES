package SweepLine.LC986IntervalListIntersections;

import java.util.ArrayList;
import java.util.List;
//You are given two lists of closed intervals, firstList and secondList
//Each list of intervals is pairwise disjoint and in sorted order.
//Return the intersection of these two interval lists.
public class Solution986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i=0,j=0;
        while(i<firstList.length && j<secondList.length){
            int intersectStart = Math.max(firstList[i][0],secondList[j][0]);
            int intersectEnd = Math.min(firstList[i][1],secondList[j][1]);
            if(intersectStart<=intersectEnd) res.add(new int[]{intersectStart,intersectEnd});
            if(firstList[i][1]<secondList[j][1]) i++;
            else j++;
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {

    }
}
