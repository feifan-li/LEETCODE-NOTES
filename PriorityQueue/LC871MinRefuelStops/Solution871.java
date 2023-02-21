package PriorityQueue.LC871MinRefuelStops;

import java.util.PriorityQueue;
//GREEDY
public class Solution871 {
    public static int minRefuelStops(int target, int startFuel, int[][] stations) {

        if(startFuel>=target) return 0;
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a,b)->b-a); //max heap
        int cnt = 0;
        int max = startFuel;
        for(int i=0;i<stations.length;++i){
            int position = stations[i][0];
            int fuel = stations[i][1];
            if(max<position){
                while(!heap.isEmpty() && max<position){
                    max += heap.poll();
                    cnt ++;
                    if(max >= target) return cnt;
                }
                if(max<position) return -1;
            }
            heap.add(fuel);
        }
        while(!heap.isEmpty() && max<target){
            max+=heap.poll();
            cnt++;
            if(max>=target) return cnt;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] stations1 = new int[][]{
                new int[]{}
        };
        int[][] stations2 = new int[][]{
                new int[]{10,100}
        };
        int[][] stations3 = new int[][]{
                new int[]{10,60},
                new int[]{20,30},
                new int[]{30,30},
                new int[]{60,40}
        };
        System.out.println(minRefuelStops(1,1,stations1));
        System.out.println(minRefuelStops(100,1,stations2));
        System.out.println(minRefuelStops(100,10,stations3));

    }
}
