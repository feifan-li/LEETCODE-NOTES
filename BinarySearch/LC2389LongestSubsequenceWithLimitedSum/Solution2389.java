package BinarySearch.LC2389LongestSubsequenceWithLimitedSum;

import java.util.Arrays;

public class Solution2389 {
    public static int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for(int i=1;i<nums.length;++i){
            nums[i] = nums[i]+nums[i-1];
        }
        for(int i=0;i<queries.length;++i){
            int target = queries[i];
            //find right bound on map
            int left = 0,right = nums.length;
            while(left<right){
                int mid = left+(right-left)/2;
                if(nums[mid]<=target){
                    left = mid+1;
                } else if(nums[mid]>target) {
                    right = mid;
                }
            }
            queries[i] = left;
        }
        return queries;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(answerQueries(new int[]{4,5,2,1},new int[]{3,10,21})));
        System.out.println(Arrays.toString(answerQueries(new int[]{2,3,4,5},new int[]{1})));
        System.out.println(Arrays.toString(answerQueries(new int[]{1,1,1,3,6,9,2,4,5,8,7},new int[]{2,3})));
    }
}
