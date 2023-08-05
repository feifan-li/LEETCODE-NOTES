package Trie_PrefixTree.LC14LongestCommonPrefix;

public class Solution14 {
    class Trie{
        class TrieNode{
            TrieNode[] nexts;
            int pass;
            int end;
            TrieNode(){
                nexts = new TrieNode[26];
                pass = 0;
                end = 0;
            }
        }
        TrieNode root;
        Trie(){
            root = new TrieNode();
        }
        void insert(String s){
            int maxPass = -1;
            TrieNode cur = root;
            cur.pass++;
            for(int i=0;i<s.length();++i){
                int path = s.charAt(i)-'a';
                if(cur.nexts[path]==null)   cur.nexts[path] = new TrieNode();
                cur = cur.nexts[path];
                cur.pass++;
            }
            cur.end++;
        }
        String prefix(String s,int k){
            //return prefix of s whose # of times s being the prefix equals k
            int maxIndex = -1;
            TrieNode cur = root;
            for(int i=0;i<s.length();++i){
                int path = s.charAt(i)-'a';
                if(cur.nexts[path]==null)    return "";
                cur = cur.nexts[path];
                if(cur.pass<k)  break;
                maxIndex = i;
            }
            return s.substring(0,maxIndex+1);
        }
    }
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==1)  return strs[0];
        Trie t = new Trie();
        for(int i=0;i<strs.length;++i)    t.insert(strs[i]);
        String lastStr = strs[strs.length-1];
        return t.prefix(lastStr,strs.length);
    }
}
