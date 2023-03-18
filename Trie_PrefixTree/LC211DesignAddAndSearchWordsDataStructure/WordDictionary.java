package Trie_PrefixTree.LC211DesignAddAndSearchWordsDataStructure;

import java.util.HashMap;

public class WordDictionary {
    class Node{
        int pass;
        int end;
        HashMap<Integer,Node> nexts;
        Node(){
            pass = 0;
            end = 0;
            nexts = new HashMap<>();
        }
    }
    public Node root;
    public WordDictionary() {
        root = new Node();
    }
    //just add word in the normal way
    public void addWord(String word) {
        char[] str = word.toCharArray();
        Node node = root;
        node.pass++;
        for(int i=0;i<str.length;++i){
            int path = (int)str[i];
            if(!node.nexts.containsKey(path)){
                node.nexts.put(path,new Node());
            }
            node = node.nexts.get(path);
            node.pass++;
        }
        node.end++;
    }
    public boolean search(String word) {
        return search(word,root);
    }
    public boolean search(String word,Node root){
        char[] str = word.toCharArray();
        Node node = root;
        for(int i=0;i<str.length;++i){
            if(str[i]=='.'){
                for(Integer path:node.nexts.keySet()){
                    Node child = node.nexts.get(path);
                    if(search(word.substring(i+1),child)) return true;
                }
                return false;
            }else{
                int path = (int)str[i];
                if(!node.nexts.containsKey(path)) return false;
                node = node.nexts.get(path);
            }
        }
        return node.end>=1;
    }
}
