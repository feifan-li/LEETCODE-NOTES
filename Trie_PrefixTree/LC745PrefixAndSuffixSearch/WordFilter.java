package Trie_PrefixTree.LC745PrefixAndSuffixSearch;

public class WordFilter {
    class Trie{
        class Node{
            int position;
            Node[] nexts;
            Node(){
                position = -1;
                nexts = new Node[27];
            }
            Node(int position){
                this.position = position;
                nexts = new Node[27];
            }
        }
        public Node root;
        public Trie(){
            root = new Node();
        }
        public void insert(String word,int position){
            char[] str = word.toCharArray();
            Node node = root;
            for(int i=0;i<str.length;++i){
                int path = str[i]-'a';
                if(node.nexts[path]==null) node.nexts[path] = new Node(position);
                node = node.nexts[path];
                node.position = Math.max(position,node.position);
            }
        }
        /**Return the largest position of word starting with prefix if existing, or -1 otherwise**/
        public int prefix(String word){
            char[] str = word.toCharArray();
            Node node = root;
            for(int i=0;i<str.length;++i){
                int path = str[i]-'a';
                if(node.nexts[path]==null) return -1;
                node = node.nexts[path];
            }
            return node.position;
        }
    }
    public Trie trie;
    public WordFilter(String[] words) {
        trie = new Trie();
        for(int pos = 0;pos<words.length;++pos){
            String word = words[pos];
            StringBuilder sb = new StringBuilder(word);
            sb.insert(0,'{');
            trie.insert(sb.toString(),pos);
            for(int i=word.length()-1;i>=0;--i){
                sb.insert(0,word.charAt(i));
                trie.insert(sb.toString(),pos);
            }
        }
    }
    public int f(String pref, String suff) {
        StringBuilder sb = new StringBuilder(suff);
        sb.append('{').append(pref);
        return trie.prefix(sb.toString());
    }
}
/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */
