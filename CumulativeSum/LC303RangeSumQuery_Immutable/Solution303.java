package CumulativeSum.LC303RangeSumQuery_Immutable;

public class Solution303 {
    //一维前缀和
    static class NumArray {
        public int[] nums;
        public int[] sum;
        public NumArray(int[] nums) {
            this.nums = nums;
            int n = this.nums.length;
            this.sum = new int[n+1];
            for(int i=1;i<=n;++i){
                sum[i] = sum[i-1] + this.nums[i-1];
            }
            //sum[i]:nums[0]+...+nums[i-1]
        }

        public int sumRange(int left, int right) {
            //sum[right+1] = nums[0]+...+nums[right];
            //sum[left] = nums[0]+...+nums[left-1];
            return this.sum[right+1] - this.sum[left];
        }
    }

    public static void main(String[] args) {
        /**
         * Your NumArray object will be instantiated and called as such:
         * NumArray obj = new NumArray(nums);
         * int param_1 = obj.sumRange(left,right);
         */
    }
}
