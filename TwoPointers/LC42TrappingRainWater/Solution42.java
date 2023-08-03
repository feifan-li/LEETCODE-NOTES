package TwoPointers.LC42TrappingRainWater;

public class Solution42 {
    public int trap(int[] height) {
        int n = height.length, left = 0, right = n-1, l_max = height[0], r_max = height[n-1], ans = 0;
        while(left<=right){
            l_max = Math.max(l_max,height[left]);
            r_max = Math.max(r_max,height[right]);
            if(l_max<r_max)     ans += l_max-height[left++];
            else    ans += r_max-height[right--];
        }
        return ans;
    }
}
