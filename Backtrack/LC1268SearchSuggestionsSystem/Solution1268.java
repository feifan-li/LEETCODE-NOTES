package Backtrack.LC1268SearchSuggestionsSystem;

import java.util.ArrayList;
import java.util.List;

public class Solution1268 {
    class Node{
        Node[] nexts;
        int pass;
        int end;
        Node(){
            nexts = new Node[26];
            pass = 0;
            end = 0;
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
        Node search(String s){
            Node cur = root;
            for(int i=0;i<s.length();++i){
                int path = s.charAt(i)-'a';
                if(cur.nexts[path]==null)   return null;
                cur = cur.nexts[path];
            }
            return cur;
        }
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans = new ArrayList<>();
        Trie t = new Trie();
        for(String product:products)    t.insert(product);
        for(int i=1;i<=searchWord.length();++i){
            ArrayList<String> list = new ArrayList<>();
            StringBuilder prefix = new StringBuilder(searchWord.substring(0,i));
            Node start = t.search(prefix.toString());
            if(start!=null) dfs(start,list,prefix);
            ans.add(new ArrayList<>(list));
        }
        return ans;
    }
    public void dfs(Node root, ArrayList<String> list,StringBuilder prefix){
        if(list.size()==3)  return;
        if(root.end>0)    list.add(prefix.toString());
        for(int i=0;i<26;++i){
            if(root.nexts[i]!=null){
                prefix.append((char)(i+'a'));
                dfs(root.nexts[i],list,prefix);
                prefix.deleteCharAt(prefix.length()-1);
            }
        }
    }
}
