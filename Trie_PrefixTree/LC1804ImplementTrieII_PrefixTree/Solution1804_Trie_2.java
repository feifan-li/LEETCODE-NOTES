package Trie_PrefixTree.LC1804ImplementTrieII_PrefixTree;

import java.util.HashMap;

public class Solution1804_Trie_2 {
    class Node {
        int pass;
        int end;
        HashMap<Integer,Node> nexts;
        Node(){
            pass = 0;
            end = 0;
            nexts = new HashMap<>();
        }
    }
    private Node root;
    public Solution1804_Trie_2() {
        root = new Node();
    }

    public void insert(String word) {
        char[] str = word.toCharArray();
        Node node = root;
        node.pass++;
        int path = 0;
        for(int i=0;i<str.length;i++){
            path = (int)str[i];
            if(!node.nexts.containsKey(path)){
                node.nexts.put(path,new Node());
            }
            node = node.nexts.get(path);
            node.pass++;
        }
        node.end++;
    }

    public int countWordsEqualTo(String word) {
        char[] str = word.toCharArray();
        Node node = root;
        int path = 0;
        for(int i=0;i<str.length;++i){
            path = (int)str[i];
            if(!node.nexts.containsKey(path)) return 0;
            node = node.nexts.get(path);
        }
        return node.end;
    }

    public int countWordsStartingWith(String prefix) {
        char[] str = prefix.toCharArray();
        Node node = root;
        int path = 0;
        for(int i=0;i<str.length;++i){
            path = (int)str[i];
            if(!node.nexts.containsKey(path)) return 0;
            node = node.nexts.get(path);
        }
        return node.pass;
    }

    public void erase(String word) {
        if(countWordsEqualTo(word)>0){
            char[] str = word.toCharArray();
            Node node = root;
            node.pass--;
            int path = 0;
            for(int i=0;i<str.length;++i){
                path = (int)str[i];
                if(--node.nexts.get(path).pass == 0){
                    node.nexts.remove(path);
                    return;
                }
                node = node.nexts.get(path);
            }
            node.end--;
        }
    }
}
