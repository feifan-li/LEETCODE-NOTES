package LC268MissingNumber;

public class Solution268 {
    public int missingNumber(int[] nums) {
        int sum = 0,n = nums.length;
        for(int num:nums)   sum += num;
        return (n*n+n)/2 - sum;
    }
}
