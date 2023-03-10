package LC398RandomPickIndex;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution398 {
    public HashMap<Integer, ArrayList<Integer>> valToIndex = new HashMap<>();
    public Solution398(int[] nums) {
        for(int i=0;i<nums.length;++i){
            if(!valToIndex.containsKey(nums[i])){
                valToIndex.put(nums[i],new ArrayList<Integer>());
            }
            valToIndex.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        ArrayList<Integer> ids = valToIndex.get(target);
        return ids.get((int)(Math.random()*ids.size()));
    }
}
