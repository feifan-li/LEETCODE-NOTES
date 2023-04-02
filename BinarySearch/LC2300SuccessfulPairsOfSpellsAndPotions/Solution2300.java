package BinarySearch.LC2300SuccessfulPairsOfSpellsAndPotions;

import java.util.Arrays;

public class Solution2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] ans = new int[n];
        Arrays.sort(potions);
        for(int i=0;i<n;++i){
            long cur = (long)spells[i];
            long target = success%cur==0?success/cur:success/cur+1;
            //find the leftmost integer that <=target
            int left = 0;
            int right = m-1;
            while(left<=right){
                int mid = left+(right-left)/2;
                if(potions[mid]<target){
                    left = mid+1;
                }else if(potions[mid]>=target){
                    right = mid-1;
                }
            }
            ans[i] = m-left;
        }
        return ans;
    }
}
