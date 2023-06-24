package DynamicProgramming.LC956TallestBillBoard;

import java.util.HashMap;
import java.util.Map;

public class Solution956 {
    public int tallestBillboard(int[] rods) {
        int n = rods.length;
        if(n<=1)    return 0;
        HashMap<Integer,Integer> dp = new HashMap<>();//diff->highest support
        dp.put(0,0);
        for(int i=0;i<n;++i){
            //if we're not welding new rod
            HashMap<Integer,Integer> new_dp = new HashMap<Integer,Integer>(dp);
            for(Map.Entry<Integer,Integer> entry:dp.entrySet()){
                int diff = entry.getKey();
                int taller = entry.getValue();
                int shorter = taller-diff;
                //weld new rod on taller side
                new_dp.put(diff+rods[i],Math.max(taller+rods[i],new_dp.getOrDefault(diff+rods[i],0)));
                //weld new rod on shorter side
                new_dp.put(Math.abs(shorter+rods[i]-taller),Math.max(Math.max(shorter+rods[i],taller),new_dp.getOrDefault(Math.abs(shorter+rods[i]-taller),0)));
            }
            dp = new_dp;
        }
        return dp.getOrDefault(0,0);
    }
}
