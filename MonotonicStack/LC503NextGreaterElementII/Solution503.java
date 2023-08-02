package MonotonicStack.LC503NextGreaterElementII;

public class Solution503 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length, top = -1;
        int[] ans = new int[n];
        int[] s = new int[2*n];//monotonic decreasing stack
        for(int i=2*n-1;i>=0;--i){
            while(top>=0 && s[top]<=nums[i%n])  top--;
            ans[i%n] = top==-1?-1:s[top];
            s[++top] = nums[i%n];
        }
        return ans;
    }
}
