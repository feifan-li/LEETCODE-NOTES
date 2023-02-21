package SweepLine.LC1229MeetingScheduler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1229 {
    public static List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1,(a, b)->a[0] - b[0]);
        Arrays.sort(slots2,(a,b)->a[0] - b[0]);
        int i=0,j=0;
        List<Integer> res = new ArrayList<>();
        while(i<slots1.length && j<slots2.length){
            int intersectStart = Math.max(slots1[i][0],slots2[j][0]);
            int intersectEnd = Math.min(slots1[i][1],slots2[j][1]);
            if(intersectEnd - intersectStart >= duration){
                res.add(intersectStart);
                res.add(intersectStart+duration);
                return res;
            }else if(slots1[i][1]<slots2[j][1]){
                i++;
            }else{
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
