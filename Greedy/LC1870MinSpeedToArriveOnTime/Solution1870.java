package Greedy.LC1870MinSpeedToArriveOnTime;

public class Solution1870 {
    public int minSpeedOnTime(int[] dist, double hour) {
        int maxDist = -1;
        for(int d:dist) maxDist = Math.max(d,maxDist);
        int left = 1, right = maxDist;
        while(left<=right){
            int mid = left + (right-left)/2;
            double curTime = getTime(dist,mid);
            if(curTime<hour){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return right;
    }
    public double getTime(int[] dist,int speed){
        double time = 0.0;
        for(int i=0;i<dist.length-1;++i){
            time += (dist[i]+speed-1)/speed;
        }
        time += (1.0*dist[dist.length-1])/(1.0*speed);
        return time;
    }
}
