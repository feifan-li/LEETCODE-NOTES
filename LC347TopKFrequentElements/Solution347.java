package LC347TopKFrequentElements;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b)->(b[0]-a[0]));
        int left = 0, right = 0;
        while(right<nums.length){
            while(right<nums.length && nums[right]==nums[left]){
                right++;
            }
            heap.offer(new int[]{right-left,nums[left]});
            left = right;
        }
        int[] ans = new int[k];
        for(int i=0;i<k;++i){
            int[] pair = heap.poll();
            ans[i] = pair[1];
        }
        return ans;
    }
}
