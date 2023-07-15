package Greedy.LC1353MaxNumberEventsCanAttend;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution1353 {
    public int maxEvents(int[][] events) {
        Arrays.sort(events,(a, b)->(a[0]==b[0]?a[1]-b[1]:a[0]-b[0]));
        int maxDays = 0;
        for(int[] e:events) maxDays = Math.max(maxDays,e[1]);
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int res = 0, i = 0;
        for(int day=1;day<=maxDays;++day){
            while(!q.isEmpty() && q.peek()<day) q.poll();
            while(i<events.length && events[i][0]==day) q.offer(events[i++][1]);
            if(!q.isEmpty()){
                q.poll();
                res++;
            }
        }
        return res;
    }
}
