package DynamicProgramming.LC247StrobogrammaticNumberII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution247 {
    public List<String> findStrobogrammatic(int n) {
        HashMap<Integer,List<String>> dp = new HashMap<>();
        List<String> ans = new ArrayList<>();
        dp.put(0,new ArrayList<String>(Arrays.asList("")));
        dp.put(1,new ArrayList<String>(Arrays.asList("0","1","8")));
        if(n<=1)    return dp.get(n);
        for(int i=(n%2==0?2:3);i<=n;i=i+2){
            List<String> cur = new ArrayList<>();
            for(String seed:dp.get(i-2)){
                cur.add("0"+seed+"0");
                cur.add("1"+seed+"1");
                cur.add("6"+seed+"9");
                cur.add("8"+seed+"8");
                cur.add("9"+seed+"6");
            }
            dp.put(i,cur);
        }
        for(String s:dp.get(n)){
            if(s.charAt(0)!='0')    ans.add(s);
        }
        return ans;
    }
}
