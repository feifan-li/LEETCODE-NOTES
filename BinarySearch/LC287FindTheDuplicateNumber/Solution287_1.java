package BinarySearch.LC287FindTheDuplicateNumber;

public class Solution287_1 {
    public int findDuplicate(int[] nums) {
        /*Time Complexity: O(n*logn)*/
        /*Space Complexity: O(1)*/
        int n = nums.length-1;
        int min = 1,max = n;
        while(min<=max){
            int mid = min+(max-min)/2;
            int count = 0;
            for(int num:nums){
                if(num<=mid)    ++count;
            }
            if(count>mid) max = mid-1;
            else min = mid+1;
        }
        return min;
    }
}
