package LC2439MinimizeMaximumOfArray;

public class Solution2439 {
    public int minimizeArrayValue(int[] nums) {
        //把大数往小数上匀
        //小数没必要往大数上匀
        //总和守恒，使最大值最小->所有数尽可能平均
        long[] sum = new long[nums.length];
        sum[0] = (long)nums[0];
        long ans = (long)nums[0];
        for(int i=1;i<nums.length;++i){
            sum[i] = sum[i-1]+(long)nums[i];
            ans = Math.max(ans,(sum[i]+(long)i)/((long)i+1));
        }
        return (int)ans;
    }
}
