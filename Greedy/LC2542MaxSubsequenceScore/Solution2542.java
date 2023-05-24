package Greedy.LC2542MaxSubsequenceScore;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution2542 {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] nums = new int[n][2];
        for(int i=0;i<n;++i){
            nums[i][0] = nums1[i];
            nums[i][1] = nums2[i];
        }
        Arrays.sort(nums,(a, b)->(b[1]-a[1]));
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        long sum = 0L;
        for(int i=0;i<k;++i){
            heap.add(nums[i][0]);
            sum += nums[i][0];
        }
        long ans = sum*nums[k-1][1];
        for(int i=k;i<n;++i){
            long min = nums[i][1];
            sum += nums[i][0]-heap.poll();
            heap.add(nums[i][0]);
            ans = Math.max(ans,sum*min);
        }
        return ans;
    }
}
