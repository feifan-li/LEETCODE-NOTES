package Backtrack.LC425WordSquares;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution425_2 {
    public HashMap<String, List<String>> prefixMap = new HashMap<>();
    public List<List<String>> ans = new ArrayList<>();
    public List<List<String>> wordSquares(String[] words) {
        for(String word:words){
            for(int i=1;i<=word.length();++i){
                if(!prefixMap.containsKey(word.substring(0,i))){
                    prefixMap.put(word.substring(0,i),new ArrayList<String>());
                }
                prefixMap.get(word.substring(0,i)).add(word);
            }
        }
        for(String word:words){
            ArrayList<String> wordSquare = new ArrayList<String>();
            wordSquare.add(word);
            backtrack(words,wordSquare);
        }
        return ans;
    }
    public void backtrack(String[] words,ArrayList<String> wordSquare){
        int sz = wordSquare.size();
        if(sz==wordSquare.get(0).length()){
            ans.add(new ArrayList<>(wordSquare));
            return;
        }
        StringBuilder prefix = new StringBuilder();
        for(String word:wordSquare) prefix.append(word.charAt(sz));
        for(String startingWithPrefix:prefixMap.getOrDefault(prefix.toString(),new ArrayList<String>())){
            wordSquare.add(startingWithPrefix);
            backtrack(words,wordSquare);
            wordSquare.remove(wordSquare.size()-1);
        }
    }
}
