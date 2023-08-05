package Trie_PrefixTree.LC1804ImplementTrieII_PrefixTree;

public class Solution1804_Trie_1 {
    class Node {
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
    public Solution1804_Trie_1() {
        root = new Node();
    }

    public void insert(String word) {
        char[] str = word.toCharArray();
        Node node = root;
        node.pass++;
        int path = 0;
        for(int i=0;i<str.length;i++){
            path = str[i]-'a';
            if(node.nexts[path]==null){
                node.nexts[path] = new Node();
            }
            node = node.nexts[path];
            node.pass++;
        }
        node.end++;
    }

    public int countWordsEqualTo(String word) {
        char[] str = word.toCharArray();
        Node node = root;
        int path = 0;
        for(int i=0;i<str.length;++i){
            path = str[i]-'a';
            if(node.nexts[path]==null) return 0;
            node = node.nexts[path];
        }
        return node.end;
    }

    public int countWordsStartingWith(String prefix) {
        char[] str = prefix.toCharArray();
        Node node = root;
        int path = 0;
        for(int i=0;i<str.length;++i){
            path = str[i]-'a';
            if(node.nexts[path]==null) return 0;
            node = node.nexts[path];
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
                path = str[i]-'a';
                if(--node.nexts[path].pass == 0){
                    node.nexts[path] = null;
                    return;
                }
                node = node.nexts[path];
            }
            node.end--;
        }
    }
}
