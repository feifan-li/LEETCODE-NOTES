package LC336PalindromePairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution336 {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        if(words.length<2)  return ans;
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<words.length;++i) map.put(words[i],i);
        for(int i=0;i<words.length;++i){
            String word = words[i];
            for(int j=0;j<=word.length();++j){
                String prefix = word.substring(0,j);
                String suffix = word.substring(j);
                if(isPalindrome(prefix)){
                    String suffixRev = new StringBuilder(suffix).reverse().toString();
                    if(map.getOrDefault(suffixRev,i)!=i)   ans.add(Arrays.asList(map.get(suffixRev),i));
                }
                if(suffix.length()!=0 && isPalindrome(suffix)){
                    String prefixRev = new StringBuilder(prefix).reverse().toString();
                    if(map.getOrDefault(prefixRev,i)!=i)    ans.add(Arrays.asList(i,map.get(prefixRev)));
                }
            }
        }
        return ans;
    }
    public boolean isPalindrome(String s){
        int i = 0, j = s.length()-1;
        while(i<=j){
            if(s.charAt(i++)!=s.charAt(j--))   return false;
        }
        return true;
    }
}
