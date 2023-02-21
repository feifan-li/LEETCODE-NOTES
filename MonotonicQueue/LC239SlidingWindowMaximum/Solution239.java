package MonotonicQueue.LC239SlidingWindowMaximum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution239 {
    static class MonotonicQueue {
        LinkedList<Integer> q = new LinkedList<>();
        public void push(int n){
            while(!q.isEmpty() && q.getLast()<n){
                q.pollLast();
            }
            q.addLast(n);
        }
        public int max(){
            return q.getFirst();
        }
        public void pop(int n){
            if(n==q.getFirst()){
                q.pollFirst();
            }
        }
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nums.length;++i){
            if(i<k-1) window.push(nums[i]);
            else{
                window.push(nums[i]);
                res.add(window.max());
                window.pop(nums[i-k+1]);
            }
        }
        int[] ans = new int[res.size()];
        for(int i=0;i<res.size();++i){
            ans[i] = res.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3,-1,-3,5,3,6,7};
        int[] res = maxSlidingWindow(nums1,3);
        System.out.println(Arrays.toString(res));
    }
}
