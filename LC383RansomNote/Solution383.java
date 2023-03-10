package LC383RansomNote;

import java.util.HashMap;

public class Solution383 {
    public boolean canConstruct(String target, String source) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<source.length();++i){
            map.put(source.charAt(i),map.getOrDefault(source.charAt(i),0)+1);
        }
        for(int i=0;i<target.length();++i){
            if(!map.containsKey(target.charAt(i))||map.get(target.charAt(i))==0) return false;
            map.put(target.charAt(i),map.get(target.charAt(i))-1);
        }
        return true;
    }
}
