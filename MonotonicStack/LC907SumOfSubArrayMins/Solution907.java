package MonotonicStack.LC907SumOfSubArrayMins;

public class Solution907 {
    public int sumSubarrayMins(int[] arr) {
        final int MOD = 1_000_000_007;
        long ans = 0L;
        int[] stack = new int[arr.length];
        int top = -1;
        for(int i=0;i<arr.length;++i){
            while(top!=-1 && arr[stack[top]]>=arr[i]){
                int minIndex = stack[top--];
                long minVal = (long)arr[minIndex];
                int leftLess = top==-1?-1:stack[top];//strictly less than minVal
                ans = (ans+(minVal*(long)(minIndex - leftLess)*(long)(i - minIndex))%MOD)%MOD;
            }
            stack[++top] = i;
        }
        while(top!=-1){
            int minIndex = stack[top--];
            long minVal = (long)arr[minIndex];
            int leftLess = top==-1?-1:stack[top];//strictly less than minVal
            ans = (ans+(minVal*(long)(minIndex - leftLess)*(long)(arr.length - minIndex))%MOD)%MOD;
        }
        return (int)ans;
    }
}
