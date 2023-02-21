package BinaryIndexedTree.LC307RangeSumQuery_Mutable;

public class Solution307 {
    class NumArray {
        public int[] a;
        public int[] tree;
        public int n;
        public NumArray(int[] nums) {
            this.n = nums.length;
            this.a = new int[n];
            this.tree = new int[n+1];

            for(int i=0;i<n;++i){
                update(i,nums[i]);
            }
        }
        public int lowbit(int i){
            return (-i)&i;
        }
        public int sum(int k){//nums[0]+...+nums[i-1]
            int ans = 0;
            for(int i=k;i>0;i-=lowbit(i)){
                ans += tree[i];
            }
            return ans;
        }
        public void update(int index, int val) {//update nums[index] to val
            int delta = val - a[index];
            a[index] = val;
            for(int j=index+1;j<=n;j+=lowbit(j)){
                tree[j] += delta;
            }
        }
        public int sumRange(int left, int right) {
            return sum(right+1)-sum(left);
        }
    }

    public static void main(String[] args) {
        /**
         * Your NumArray object will be instantiated and called as such:
         * NumArray obj = new NumArray(nums);
         * obj.update(index,val);
         * int param_2 = obj.sumRange(left,right);
         */
    }
}
