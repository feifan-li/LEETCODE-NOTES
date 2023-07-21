package LC17LetterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution17 {
    HashMap<String,List<String>> memo = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        memo.put("",new ArrayList<>());
        memo.put("2", Arrays.asList("a","b","c"));
        memo.put("3",Arrays.asList("d","e","f"));
        memo.put("4",Arrays.asList("g","h","i"));
        memo.put("5",Arrays.asList("j","k","l"));
        memo.put("6",Arrays.asList("m","n","o"));
        memo.put("7",Arrays.asList("p","q","r","s"));
        memo.put("8",Arrays.asList("t","u","v"));
        memo.put("9",Arrays.asList("w","x","y","z"));
        return helper(digits);
    }
    public List<String> helper(String digits){
        if(memo.containsKey(digits))    return memo.get(digits);
        List<String> res = new ArrayList<>();
        List<String> left = memo.get(digits.substring(0,1));
        List<String> right = helper(digits.substring(1));
        for(String l:left){
            for(String r:right) res.add(l+r);
        }
        memo.put(digits,res);
        return res;
    }
}
