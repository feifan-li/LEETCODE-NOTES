package PrefixSum.LC396RotateFunction;

public class Solution396 {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length, cur = 0;
        int[] arr = new int[n*2];
        for(int i=0;i<n;++i){
            arr[i] = nums[i];
            arr[i+n] = nums[i];
        }
        int[] sum = new int[n*2];
        sum[0] = arr[0];
        for(int i=1;i<n*2;++i)    sum[i] = arr[i]+sum[i-1];
        for(int i=0;i<n;++i)    cur += i*nums[i];
        int max = cur;
        for(int k=n-1;k>=0;--k){
            cur -= (n-1)*(arr[k+n]);
            cur += sum[k+n-1]-sum[k];
            max = Math.max(cur,max);
        }
        return max;
    }
}
