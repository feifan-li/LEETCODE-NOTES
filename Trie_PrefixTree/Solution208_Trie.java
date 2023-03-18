package Trie_PrefixTree;

public class Solution208_Trie {
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
    private Node root;
    public Solution208_Trie() {
        root = new Node();
    }

    public void insert(String word) {
        char[] str = word.toCharArray();
        int path = 0;
        Node node = root;
        node.pass ++;
        for(int i=0;i<str.length;++i){
            path = str[i] - 'a';
            if(node.nexts[path]==null) node.nexts[path] = new Node();
            node = node.nexts[path];
            node.pass++;
        }
        node.end++;
    }

    public boolean search(String word) {
        char[] str = word.toCharArray();
        int path = 0;
        Node node = root;
        for(int i=0;i<str.length;++i){
            path = str[i] - 'a';
            if(node.nexts[path]==null) return false;
            node = node.nexts[path];
        }
        return node.end >=1;
    }

    public boolean startsWith(String prefix) {
        char[] str = prefix.toCharArray();
        int path = 0;
        Node node = root;
        for(int i=0;i<str.length;++i){
            path = str[i] - 'a';
            if(node.nexts[path]==null) return false;
            node = node.nexts[path];
        }
        return node.pass>0;
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
