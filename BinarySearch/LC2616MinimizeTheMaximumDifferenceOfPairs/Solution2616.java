package BinarySearch.LC2616MinimizeTheMaximumDifferenceOfPairs;

import java.util.Arrays;

public class Solution2616 {
    /*******************************
     Binary Search Over Results
     ********************************/
    public int minimizeMax(int[] nums, int p) {
        if(p==0)    return 0;
        Arrays.sort(nums);
        int[] diff = new int[nums.length-1];
        for(int i=0;i<diff.length;++i)  diff[i] = Math.abs(nums[i]-nums[i+1]);
        int left = 0, right = 0;
        for(int i=0;i<diff.length;++i)  right = Math.max(right,diff[i]);
        while(left<=right){
            int mid = left+(right-left)/2;
            if(count(diff,mid)>=p)  right = mid-1;
            else left = mid+1;
        }
        return left;
    }
    public int count(int[] diff, int p){
        int cnt = 0, i = 0;
        while(i<diff.length){
            if(diff[i]<=p){
                cnt++;
                i++;
            }
            i++;
        }
        return cnt;
    }
}
