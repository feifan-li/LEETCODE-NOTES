package Strings.LC249GroupShiftedStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution249 {
    public List<List<String>> groupStrings(String[] strings) {
        String[] keys = new String[strings.length];
        for(int i=0;i<strings.length;++i){
            StringBuilder sb = new StringBuilder();
            for(int j = 1;j<strings[i].length();++j){
                sb.append((strings[i].charAt(j) - strings[i].charAt(j-1) + 26)%26).append(",");
            }
            keys[i] = sb.toString();
        }
        HashMap<String,List<String>> map = new HashMap<>();
        for(int i=0;i<keys.length;++i){
            if(!map.containsKey(keys[i]))   map.put(keys[i],new ArrayList<String>());
            map.get(keys[i]).add(strings[i]);
        }
        return new ArrayList<>(map.values());
    }
}
