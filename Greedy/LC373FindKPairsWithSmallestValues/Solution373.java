package Greedy.LC373FindKPairsWithSmallestValues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b)->(a[0]+a[1]-b[0]-b[1]));
        for(int i=0;i<Math.min(nums1.length,k);++i) heap.offer(new int[]{nums1[i],nums2[0],0});
        while(!heap.isEmpty() && (k--)>0){
            int[] min = heap.poll();
            ans.add(new ArrayList<Integer>(Arrays.asList(min[0],min[1])));
            if(min[2]+1<nums2.length)   heap.offer(new int[]{min[0],nums2[min[2]+1],min[2]+1});
        }
        return ans;
    }
}
