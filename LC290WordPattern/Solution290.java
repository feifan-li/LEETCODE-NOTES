package LC290WordPattern;

import java.util.HashMap;

public class Solution290 {
    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(pattern.length()!=words.length) return false;
        int n = pattern.length();
        HashMap<Character,String> map = new HashMap<>();
        for(int i=0;i<n;++i){
            char p = pattern.charAt(i);
            String word = words[i];
            if(map.containsKey(p)){
                if(!map.get(p).equals(word)) return false;
            }else{
                if(!map.containsValue(word)) map.put(p,word);
                else return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba","dog dog dog dog"));
    }
}
