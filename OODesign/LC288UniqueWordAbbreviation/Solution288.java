package OODesign.LC288UniqueWordAbbreviation;

import java.util.HashMap;
import java.util.HashSet;

class ValidWordAbbr {
    public HashMap<String, HashSet<String>> map = new HashMap<>();
    public ValidWordAbbr(String[] dictionary) {
        for(String s:dictionary){
            if(s.length()==1 && s.length()==2){
                if(!map.containsKey(s)) map.put(s,new HashSet<String>());
                map.get(s).add(s);
            }else{
                String abbr = s.charAt(0)+((s.length()-2)+"")+s.charAt(s.length()-1);
                if(!map.containsKey(abbr))   map.put(abbr, new HashSet<String>());
                map.get(abbr).add(s);
            }
        }
    }

    public boolean isUnique(String s) {
        if(s.length()<=2){
            return !map.containsKey(s) || (map.get(s).contains(s) && map.get(s).size()==1);
        }
        String abbr = s.charAt(0)+((s.length()-2)+"")+s.charAt(s.length()-1);
        return !map.containsKey(abbr) || (map.get(abbr).contains(s) && map.get(abbr).size()==1);
    }
}
