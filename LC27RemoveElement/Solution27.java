package LC27RemoveElement;

import java.util.Arrays;
import java.util.Collections;

public class Solution27 {
    public static int removeElement(int[] nums, int val) {
        int ans = 0;
        for(int i=0;i<nums.length;++i){
            if(nums[i]==val) nums[i]=Integer.MAX_VALUE;
            else ans++;
        }
        Arrays.sort(nums);
        return ans;
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{3,2,2,3};
        System.out.println(removeElement(test1,3));
    }
}
