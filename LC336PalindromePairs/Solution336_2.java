package LC336PalindromePairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution336_2 {
    class TrieNode{
        TrieNode[] nexts;
        List<Integer> palindromeSuffix;
        int end;
        TrieNode(){
            nexts = new TrieNode[26];
            palindromeSuffix = new ArrayList<>();
            end = -1;
        }
    }
    public List<List<Integer>> palindromePairs(String[] words) {
        TrieNode root = new TrieNode();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<words.length;++i){
            String wordRev = new StringBuilder(words[i]).reverse().toString();
            TrieNode cur = root;
            for(int j=0;j<wordRev.length();++j){
                if(isPalindrome(wordRev,j)) cur.palindromeSuffix.add(i);
                if(cur.nexts[wordRev.charAt(j)-'a']==null)  cur.nexts[wordRev.charAt(j)-'a'] = new TrieNode();
                cur = cur.nexts[wordRev.charAt(j)-'a'];
            }
            cur.end = i;
        }
        for(int i=0;i<words.length;++i){
            String word = words[i];
            TrieNode cur = root;
            int j=0;
            for(;j<word.length();++j){
                if(isPalindrome(word,j) && cur.end!=-1)  ans.add(Arrays.asList(i,cur.end));
                cur = cur.nexts[word.charAt(j)-'a'];
                if(cur==null) break;
            }
            if(cur==null)   continue;
            if(cur.end!=-1 && i!=cur.end)   ans.add(Arrays.asList(i,cur.end));
            for(int k:cur.palindromeSuffix) ans.add(Arrays.asList(i,k));
        }
        return ans;
    }
    public boolean isPalindrome(String s,int start){
        int i = start, j = s.length()-1;
        while(i<=j){
            if(s.charAt(i++)!=s.charAt(j--))   return false;
        }
        return true;
    }
}
