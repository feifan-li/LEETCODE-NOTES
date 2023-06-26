package LC2462TotalCostToHireKWorkers;

import java.util.PriorityQueue;

public class Solution2462 {
    public long totalCost(int[] costs, int k, int candidates) {
        long ans = 0L;
        int n = costs.length, i=0, lr = -1, rl = n;//leftSideRight, rightSideLeft;
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b)->(a[0]==b[0]?a[1]-b[1]:a[0]-b[0]));
        if(2*candidates<=n){
            for(i=0;i<candidates;++i){
                heap.offer(new int[]{costs[++lr],lr});
                heap.offer(new int[]{costs[--rl],rl});
            }
            while(k!=0 && lr<rl-1){
                int[] worker = heap.poll();
                ans += worker[0];
                k--;
                if(worker[1]<=lr)    heap.offer(new int[]{costs[lr+1],++lr});
                else if(worker[1]>=rl)    heap.offer(new int[]{costs[rl-1],--rl});
            }
        }
        if(heap.isEmpty()){
            for(i=0;i<n;++i)    heap.offer(new int[]{costs[i],i});
        }
        while((k--)!=0) ans += heap.poll()[0];
        return ans;
    }
}
