package FlipGame.LC294FlipGameII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution294 {
    public boolean canWin(String s) {
        if(s.length()<=1)   return false;
        HashMap<String,Boolean> memo = new HashMap<>();
        return helper(memo,s);
    }
    public boolean helper(HashMap<String,Boolean> memo,String s){
        if(memo.containsKey(s)) return memo.get(s);
        for(String next:generatePossibleNextMoves(s)){
            if(!helper(memo,next)){
                memo.put(s,true);
                return true;
            }
        }
        memo.put(s,false);
        return false;
    }
    public List<String> generatePossibleNextMoves(String s) {
        List<String> ans = new ArrayList<>();
        char[] arr = s.toCharArray();
        for(int i=0;i<s.length()-1;++i){
            if(arr[i]=='+' && arr[i+1]=='+'){
                arr[i]='-';
                arr[i+1]='-';
                ans.add(new String(arr));
                arr[i]='+';
                arr[i+1]='+';
            }
        }
        return ans;
    }
}
