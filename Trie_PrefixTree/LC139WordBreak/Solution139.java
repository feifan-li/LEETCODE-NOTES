package Trie_PrefixTree.LC139WordBreak;

import java.util.List;

public class Solution139 {
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
            node.pass ++;
            for(int i=0;i<str.length;++i){
                int path = str[i]-'a';
                if(node.nexts[path]==null) node.nexts[path] = new Node();
                node = node.nexts[path];
                node.pass ++;
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
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie wordTrie = new Trie();
        for(String word:wordDict) wordTrie.insert(word);
        boolean[] opt = new boolean[s.length()+1];
        opt[0] = true;
        //opt[i] whether first i chars can be ...
        for(int i=1;i<=s.length();++i){
            for(int j=0;j<i;j++){
                opt[i] = opt[j]&(wordTrie.contains(s.substring(j,i)));
                if(opt[i]==true) break;
            }
        }
        return opt[s.length()];
    }
}
