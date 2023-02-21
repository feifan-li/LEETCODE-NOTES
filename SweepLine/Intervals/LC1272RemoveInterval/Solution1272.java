package SweepLine.Intervals.LC1272RemoveInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//You are given a sorted list of disjoint intervals
public class Solution1272 {
    public static List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res = new ArrayList<>();
        for(int[] i:intervals){
            if(i[1] <= toBeRemoved[0] || i[0] >= toBeRemoved[1]){//no overlap
                res.add(Arrays.asList(i[0],i[1]));
            }else{//overlap: i[1]>toBeRemoved[0] && i[0] <toBeRemoved[1]
                if(i[0]<toBeRemoved[0]) res.add(Arrays.asList(i[0],toBeRemoved[0]));
                if(i[1]>toBeRemoved[1]) res.add(Arrays.asList(toBeRemoved[1],i[1]));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(removeInterval(new int[][]{{0,2},{3,4},{5,7}},new int[]{1,6}));
        System.out.println(removeInterval(new int[][]{{0,5}},new int[]{2,3}));
        System.out.println(removeInterval(new int[][]{{-5,-4},{-3,-2},{1,2},{3,5},{8,9}},new int[]{-1,4}));
    }
}
