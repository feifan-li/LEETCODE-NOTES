package BinarySearch.LC2187MinTimeToCompleteTrips;

import java.util.Arrays;

public class Solution2187 {
    public int[] times;
    public long minimumTime(int[] times, int totalTrips) {
        Arrays.sort(times);
        this.times = times;
        int minTime = times[0];
        long rightTime = (long)minTime*totalTrips;
        long leftTime = minTime;
        while(leftTime<=rightTime){
            long mid = leftTime + (rightTime-leftTime)/2;
            if(!canFinishWithin(mid,totalTrips)){
                leftTime = mid+1;
            }else{
                rightTime = mid-1;
            }
        }
        return leftTime;
    }
    private boolean canFinishWithin(long time,int totalTrips){
        int curTrips = 0;
        for(int i=0;i<times.length;++i){
            if((long)times[i]>time) break;
            curTrips += (int)(time/(long)times[i]);
            if(curTrips>=totalTrips) return true;
        }
        return curTrips>=totalTrips;
    }
}
