package DynamicProgramming.LC1125SmallestSufficientTeam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution1125 {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int m = req_skills.length, n = people.size();
        HashMap<String,Integer> skillId = new HashMap<>();
        for(int i=0;i<m;++i)    skillId.put(req_skills[i],i);
        int[] peopleSkills = new int[n];
        for(int i=0;i<n;++i){
            for(String skill:people.get(i)){
                int sid = skillId.getOrDefault(skill,-1);
                if(sid>=0)  peopleSkills[i] |= (1<<sid);
            }
        }
        long[] dp = new long[(1<<m)];
        Arrays.fill(dp,(1L<<n)-1);
        dp[0] = 0L;
        for(int skillMask = 1;skillMask<(1<<m);++skillMask){
            for(int i=0;i<n;i++){
                int remainingSkillMask = skillMask & (~peopleSkills[i]);
                if(remainingSkillMask != skillMask){
                    long teamMask = dp[remainingSkillMask] | (1L<<i);
                    if(Long.bitCount(teamMask)<Long.bitCount(dp[skillMask]))    dp[skillMask] = teamMask;
                }
            }
        }
        long teamMask = dp[(1<<m)-1];
        int[] ans = new int[Long.bitCount(teamMask)];
        int j = 0;
        for(int i=0;i<n;i++){
            if(((teamMask >> i) & 1) == 1)    ans[j++] = i;
        }
        return ans;
    }
}
