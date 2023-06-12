package LC238ProductofArrayExceptSelf;

public class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int product = 1, productRev = 1;
        for(int i=0;i<ans.length;++i){
            ans[i] = product;
            product *= nums[i];
        }
        for(int i=ans.length-1;i>=0;--i){
            ans[i] *= productRev;
            productRev *= nums[i];
        }
        return ans;
    }
}
