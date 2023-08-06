package Backtrack.LC425WordSquares;

import java.util.ArrayList;
import java.util.List;

public class Solution425 {
    class Node{
        int pass;
        int end;
        Node[] nexts;
        Node(){
            pass = 0;
            end = 0;
            nexts = new Node[26];
        }
    }
    class Trie{
        Node root;
        Trie(){
            root = new Node();
        }
        void insert(String s){
            Node cur = root;
            cur.pass++;
            for(int i=0;i<s.length();++i){
                int path = s.charAt(i)-'a';
                if(cur.nexts[path]==null)   cur.nexts[path] = new Node();
                cur = cur.nexts[path];
                cur.pass++;
            }
            cur.end++;
        }
        Node prefix(String s){
            Node cur = root;
            for(int i=0;i<s.length();++i){
                int path = s.charAt(i)-'a';
                if(cur.nexts[path]==null)   return null;
                cur = cur.nexts[path];
            }
            return cur;
        }
    }
    public Trie t = new Trie();
    public List<List<String>> ans = new ArrayList<>();
    public List<List<String>> wordSquares(String[] words) {
        for(String word:words)  t.insert(word);
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
        for(String startingWithPrefix:getStringsStartingWith(prefix.toString())){
            wordSquare.add(startingWithPrefix);
            backtrack(words,wordSquare);
            wordSquare.remove(wordSquare.size()-1);
        }
    }
    public List<String> getStringsStartingWith(String prefix){
        Node start = t.prefix(prefix);
        List<String> res = new ArrayList<String>();
        if(start==null) return res;
        StringBuilder sb = new StringBuilder(prefix);
        dfsTrie(start,res,sb);
        return res;
    }
    public void dfsTrie(Node start, List<String> res, StringBuilder sb){
        if(start.end>0) res.add(sb.toString());
        for(int i=0;i<26;++i){
            if(start.nexts[i]!=null){
                sb.append((char)(i+'a'));
                dfsTrie(start.nexts[i],res,sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
