package DynamicProgramming.LC1402ReducingDishes;

import java.util.Arrays;

public class Solution1402 {
    public int maxSatisfaction(int[] s) {
        int n = s.length;
        int time = 1;
        int ans = 0;
        Arrays.sort(s);
        if(s[n-1]<=0) return 0;
        for(int i=0;i<n;++i){
            ans += time*s[i];
            time++;
        }
        if(s[0]>=0) return ans;
        int[] sum = new int[n];
        sum[0] = s[0];
        for(int i=1;i<n;++i) sum[i] = sum[i-1]+s[i];
        //some are negative,some are positive
        // ans = -3
        //-9,-8,-1,0,5 ->if remove -9,gain 9*1 but lose (-8+-1+0+5), total gain 13,ans = 10
        //-8,-1,0,5 ->if remove -8,gain 8*1 but lose(-1+0+5),total gain 4, ans = 14
        //-1,0,5 ->if remove -1,gain 1 but lose(0+5),total gain -4, so do not remove!
        //0,5 ->now looking at non-negative number, can safely break and return ans!
        time = 1;
        for(int i=0;i<n;++i){
            if(s[i]>=0) break;
            int gainAfterRemoveCur = (-1)*time*(s[i])-(sum[n-1]-sum[i]);
            if(gainAfterRemoveCur<=0){
                time++;
            }else{
                ans += gainAfterRemoveCur;
                time = time;
            }
        }
        return ans;
    }
}
