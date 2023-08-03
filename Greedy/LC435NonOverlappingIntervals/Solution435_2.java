package Greedy.LC435NonOverlappingIntervals;

import java.util.Arrays;

public class Solution435_2 {
    public static int eraseOverlapIntervals2(int[][] intervals) {
        Arrays.sort(intervals,(a, b)->a[1]-b[1]);
        int count = 0, end = Integer.MIN_VALUE;
        for(int[] i:intervals){
            if(end<=i[0]) end = i[1];
            else count++;//Greedy: 删除的是较早结束的, 为后续interval留下更多空间
        }
        return count;
    }
}
