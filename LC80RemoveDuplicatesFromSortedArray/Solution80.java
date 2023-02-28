package LC80RemoveDuplicatesFromSortedArray;

import java.util.HashMap;

public class Solution80 {
    public static int removeDuplicates(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int oldIndex = 0;
        int newIndex = 0;
        while(oldIndex<nums.length){
            map.put(nums[oldIndex],map.getOrDefault(nums[oldIndex],0)+1);
            if(map.get(nums[oldIndex])<=2){
                if(newIndex!=oldIndex) nums[newIndex] = nums[oldIndex];
                newIndex++;
                oldIndex++;
            }else{
                while(oldIndex<nums.length && map.getOrDefault(nums[oldIndex],1)>2) oldIndex++;
            }
        }
        return newIndex;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,1,2,2,3}));
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
    }
}
