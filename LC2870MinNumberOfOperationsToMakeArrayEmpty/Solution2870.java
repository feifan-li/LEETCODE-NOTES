package LC2870MinNumberOfOperationsToMakeArrayEmpty;

import java.util.HashMap;
import java.util.Map;

public class Solution2870 {
    public int minOperations(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int ans = 0;
        for(Map.Entry<Integer,Integer> ent:map.entrySet()){
            int cnt = ent.getValue();
            if(cnt==1){
                return -1;
            }else if(cnt==2){
                ans += 1;
            }else if(cnt%3==0){
                ans += cnt/3;
            }else{
                ans += cnt/3;
                ans += 1;
            }
        }
        return ans;
    }
}
