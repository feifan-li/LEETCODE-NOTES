package DynamicProgramming.LC248StrobogrammaticNumberIII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution248 {
    public int strobogrammaticInRange(String low, String high) {
        HashMap<Integer, List<String>> dp = new HashMap<>();
        dp.put(0,new ArrayList<String>(Arrays.asList("")));
        dp.put(1,new ArrayList<String>(Arrays.asList("0","1","8")));
        for(int i=2;i<=high.length();i=i+1){
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
        int res = 0;
        for(String s:dp.get(low.length())){
            if(Long.parseLong(s)>=Long.parseLong(low) && Long.parseLong(s)<=Long.parseLong(high))  res++;
        }
        for(int i=low.length()+1;i<high.length();++i)   res += (dp.get(i).size()/5)*4;
        if(high.length()>low.length()){
            for(String s:dp.get(high.length())){
                if(Long.parseLong(s)<=Long.parseLong(high)){
                    if(high.length()==1)    res++;
                    else if(s.charAt(0)!='0')    res++;
                }
            }
        }
        return res;
    }
}
