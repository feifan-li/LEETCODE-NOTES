package MonotonicQueue.LC1696JumpGameVI;

import java.util.LinkedList;

public class Solution1696 {
    static class MonotonicQueue{
        private LinkedList<Integer> q;
        public MonotonicQueue(){
            q = new LinkedList<>();
        }
        public void push(int n){
            while(!q.isEmpty() && q.getLast()<n){
                q.removeLast();
            }
            q.addLast(n);
        }
        public int getMax(){
            return this.q.getFirst();
        }
        public void pop(int n){
            if(n==this.q.getFirst()){
                this.q.removeFirst();
            }
        }
    }
    public static int maxResult(int[] nums, int k) {
        //dp[i] : max score from i to n-1
        int n = nums.length;
        int[] dp = new int[n];
        dp[n-1] = nums[n-1];
        MonotonicQueue q = new MonotonicQueue();
        q.push(dp[n-1]);
        for(int i=n-2;i>=0;i--){
            if(i>=n-k){
                dp[i] = nums[i]+q.getMax();
                q.push(dp[i]);
            }else{
                dp[i] = nums[i]+q.getMax();
                q.pop(dp[i+k]);
                q.push(dp[i]);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(maxResult(new int[]{1,-1,-2,4,-7,3},2));
        System.out.println(maxResult(new int[]{10,-5,-2,4,0,3},3));
        System.out.println(maxResult(new int[]{1,-5,-20,4,-1,3,-6,-3},2));

    }
}
