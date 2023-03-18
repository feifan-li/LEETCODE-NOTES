package Trie_PrefixTree.LC140WordBreakII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution140 {
    class Trie{
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
        public Node root;
        public Trie(){
            root = new Node();
        }
        public void insert(String word){
            char[] str = word.toCharArray();
            Node node = root;
            node.pass++;
            for(int i=0;i<str.length;++i){
                int path = str[i]-'a';
                if(node.nexts[path]==null) node.nexts[path] = new Node();
                node = node.nexts[path];
                node.pass++;
            }
            node.end++;
        }
        public boolean contains(String word){
            char[] str = word.toCharArray();
            Node node = root;
            for(int i=0;i<str.length;++i){
                int path = str[i]-'a';
                if(node.nexts[path]==null) return false;
                node = node.nexts[path];
            }
            return node.end>=1;
        }
    }
    public Map<Integer, List<String>> map = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        Trie wordTrie = new Trie();
        for(String word:wordDict) wordTrie.insert(word);
        return helper(s,wordTrie,0);
    }
    private List<String> helper(String s, Trie wordTrie, int start){
        if(map.containsKey(start)){
            return map.get(start);
        }
        List<String> res = new ArrayList<>();
        if(start==s.length()){
            res.add("");
        }
        for(int end = start+1;end<=s.length();++end){
            if(wordTrie.contains(s.substring(start,end))){
                List<String> list = helper(s,wordTrie,end);
                for(String tmp : list){
                    res.add(s.substring(start,end)+(tmp.equals("")?"":" ")+tmp);
                }
            }
        }
        map.put(start,res);
        return res;
    }
}
