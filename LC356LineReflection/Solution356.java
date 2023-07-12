package LC356LineReflection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution356 {
    public boolean isReflected(int[][] points) {
        Arrays.sort(points,(a, b)->(a[1]==b[1]?a[0]-b[0]:a[1]-b[1]));
        List<long[]> longPoints = new ArrayList<>();
        for(int i=0;i<points.length;++i){
            if(i>0 && points[i][0]==points[i-1][0] && points[i][1]==points[i-1][1]){
                continue;
            }
            longPoints.add(new long[]{10L*(long)points[i][0],10L*(long)points[i][1]});
        }
        List<long[]> centers = new ArrayList<>();
        int i = 0;
        while(i<longPoints.size()){
            int nexti = i;
            while(nexti<longPoints.size() && longPoints.get(i)[1]==longPoints.get(nexti)[1])    nexti++;
            centers.add(getCenter(longPoints,i,nexti-1));
            i = nexti;
        }
        for(long[] center:centers){
            if(center[1]==0 || center[0]!=centers.get(0)[0])    return false;
        }
        return true;
    }
    public long[] getCenter(List<long[]> longPoints, int start, int end){
        int n = end-start+1;
        long medianX = 0L;
        if(n%2==1)  medianX = longPoints.get((start+end)/2)[0];
        else medianX = (longPoints.get((start+end)/2)[0] + longPoints.get((start+end)/2 + 1)[0])/2;
        while(start<=end){
            if(2*medianX != longPoints.get(start)[0]+longPoints.get(end)[0]){
                return new long[2];
            }
            start++;
            end--;
        }
        return new long[]{medianX,1L};
    }
}
