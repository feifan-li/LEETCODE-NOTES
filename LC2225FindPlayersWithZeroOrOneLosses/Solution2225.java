package LC2225FindPlayersWithZeroOrOneLosses;

import java.util.*;

public class Solution2225 {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> winner = new HashSet<>();
        HashMap<Integer,Integer> loser = new HashMap<>();
        for(int[] m:matches){
            winner.add(m[0]);
            loser.put(m[1],loser.getOrDefault(m[1],0)+1);
        }
        List<Integer> ans0 = new ArrayList<>();
        for(int w:winner){
            if(!loser.containsKey(w)){
                ans0.add(w);
            }
        }
        Collections.sort(ans0);
        ans.add(ans0);
        List<Integer> ans1 = new ArrayList<>();
        for(Map.Entry<Integer,Integer> ent:loser.entrySet()){
            if(ent.getValue()==1){
                ans1.add(ent.getKey());
            }
        }
        Collections.sort(ans1);
        ans.add(ans1);
        return ans;
    }
}
