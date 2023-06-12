package BinarySearch.LC245ShortestWordDistanceIII;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution245 {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<wordsDict.length;++i){
            String word = wordsDict[i];
            if(!map.containsKey(word))  map.put(word,new ArrayList<Integer>());
            map.get(word).add(i);
        }
        int ans = Integer.MAX_VALUE;
        ArrayList<Integer> nums1 = map.get(word1);
        ArrayList<Integer> nums2 = map.get(word2);
        for(int num1:nums1){
            if(num1<nums2.get(0)){
                ans = Math.min(ans,nums2.get(0) - num1);
            }else if(num1>nums2.get(nums2.size()-1)){
                ans = Math.min(ans,num1 - nums2.get(nums2.size()-1));
            }else{
                ans = Math.min(ans,Math.min(num1 - maxElementLessThan(nums2,num1), minElementGreaterThan(nums2,num1) - num1));
            }
        }
        return ans;
    }
    public int maxElementLessThan(ArrayList<Integer> nums,int target){
        int left = 0, right = nums.size()-1;
        int ans = -999999;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums.get(mid)>=target){
                right = mid-1;
            }else{
                left = mid+1;
                ans = nums.get(mid);
            }
        }
        return ans;
    }
    public int minElementGreaterThan(ArrayList<Integer> nums,int target){
        int left = 0,right = nums.size()-1;
        int ans = 999999;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums.get(mid)<=target){
                left = mid+1;
            }else{
                right = mid-1;
                ans = nums.get(mid);
            }
        }
        return ans;
    }
}
