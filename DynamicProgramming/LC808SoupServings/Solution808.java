package DynamicProgramming.LC808SoupServings;

import java.util.HashMap;

public class Solution808 {
    public int[][] ops = new int[][]{{4,0},{3,1},{2,2},{1,3}};
    public HashMap<Integer, HashMap<Integer,Double>> memo = new HashMap<>();
    public double soupServings(int n){
        int m = (n+24)/25;
        return m>=200?1.0:helper(m,m);
    }
    public double helper(int a,int b){
        double ans = 0.0;
        if(a<=0 && b>0) return 1.0;
        if(a<=0 && b<=0)    return 0.5;
        if(b<=0 && a>0) return 0.0;
        if(memo.containsKey(a) && memo.get(a).containsKey(b))   return memo.get(a).get(b);
        for(int[] op:ops)   ans += 0.25*helper(a-op[0],b-op[1]);
        if(!memo.containsKey(a))    memo.put(a,new HashMap<>());
        memo.get(a).put(b,ans);
        return ans;
    }
}
