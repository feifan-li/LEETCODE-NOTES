package LC1834SingleThreadedCPU;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution1834 {
    public static int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] tList = new int[n][3];
        for(int i=0;i<n;++i){
            tList[i] = new int[]{tasks[i][0],tasks[i][1],i};
        }
        Arrays.sort(tList,(a, b)->a[0]-b[0]);
        int[] ans = new int[n];
        PriorityQueue<int[]> heap =
                new PriorityQueue<>((a,b)->a[1]==b[1]?a[2]-b[2]:a[1]-b[1]);
        int time = 0,i=0,ansp=0;
        while(i<n){
            while(i<n && tList[i][0]<=time){
                heap.offer(tList[i]);
                i++;
            }
            if(heap.isEmpty()){//heap
                time = tList[i][0];
            }
            if(!heap.isEmpty()){
                int[] task = heap.poll();
                ans[ansp++] = task[2];
                time += task[1];
            }
        }
        //now all tasks are added to heap
        while(!heap.isEmpty()){
            int[] task = heap.poll();
            ans[ansp++] = task[2];
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getOrder(new int[][]{{1, 2}, {2, 4}, {3, 2}, {4, 1}})));
        System.out.println(Arrays.toString(getOrder(new int[][]{{7, 10}, {7, 12}, {7, 5}, {7, 4}, {7, 2}})));
    }
}
