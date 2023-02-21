package CumulativeSum.LC325MaxSizeSubarraySumEqualsK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Solution325 {
    public static int maxSubArrayLen(int[] nums, int k) {
        int n = nums.length;
        //map: nums[0] + ... + nums[i] to index list
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        map.put(0,new ArrayList<Integer>(Arrays.asList(-1)));
        int ans = 0;
        int sum_i = 0;
        for(int i=0;i<n;++i){
            sum_i += nums[i];
            int sum_j = sum_i - k;
            if(map.containsKey(sum_j)) ans = Math.max(ans,i - map.get(sum_j).get(0));
            if(!map.containsKey(sum_i)) map.put(sum_i,new ArrayList<Integer>(Arrays.asList(i)));
            else{
                ArrayList<Integer> list = map.get(sum_i);
                list.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArrayLen(new int[]{1,-1,5,-2,3},3));
        System.out.println(maxSubArrayLen(new int[]{-2,-1,2,1},1));
    }
}
