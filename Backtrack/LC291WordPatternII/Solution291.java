package Backtrack.LC291WordPatternII;

import java.util.HashMap;

public class Solution291 {
    //backtrack:
    public boolean wordPatternMatch(String pattern, String s) {
        HashMap<Character,String> map = new HashMap<>();
        return isMatch(s,0,pattern,0,map);
    }
    private boolean isMatch(String s,int i,String pattern,int j,HashMap<Character,String> map){
        if(i==s.length() && j==pattern.length()) return true;
        if(i==s.length() || j==pattern.length()) return false;

        char p = pattern.charAt(j);
        if(map.containsKey(p)){
            String str = map.get(p);
            if(!s.startsWith(str,i)) return false;
            return isMatch(s,i+str.length(),pattern,j+1,map);
        }//else, make choices on s
        for(int k=i;k<s.length();++k){
            String word = s.substring(i,k+1);
            if(map.containsValue(word)) continue;//this choice is false
            map.put(p,word);
            if(isMatch(s,k+1,pattern,j+1,map)) return true;
            map.remove(p);
        }
        return false;
    }
}
