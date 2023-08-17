package Trie_PrefixTree.LC1166DesignFileSystem;

import java.util.HashMap;

public class FileSystem {
    class Node{
        int pass;
        int end;
        int value;
        HashMap<Integer,Node> nexts;
        Node(){
            this.pass = 0;
            this.end = 0;
            this.value = -1;
            nexts = new HashMap<>();
        }
    }
    class Trie{
        Node root;
        Trie(){
            this.root = new Node();
        }
        void insert(String s, Node start, int val){
            start.pass++;
            for(int i=0;i<s.length();++i){
                int path = (int)(s.charAt(i));
                if(!start.nexts.containsKey(path))    start.nexts.put(path,new Node());
                start = start.nexts.get(path);
                start.pass++;
            }
            start.end++;
            start.value = val;
        }
        Node search(String s, Node cur){
            for(int i=0;i<s.length();++i){
                int path = (int)(s.charAt(i));
                if(!cur.nexts.containsKey(path))    return null;
                cur = cur.nexts.get(path);
            }
            return cur.end>0?cur:null;
        }
    }
    public Trie t;
    public FileSystem() {
        this.t = new Trie();
    }

    public boolean createPath(String path, int value) {
        //split path into two part
        int n = path.length(), j=n-1;
        while(path.charAt(j)!='/')  j--;
        //check whether parent path exists
        Node parent = t.search(path.substring(0,j),t.root);
        if(j>0 && parent==null)    return false;
        //check whether path already exists
        Node cur = t.search(path.substring(j,n),parent==null?t.root:parent);
        if(cur!=null)   return false;
        //insert new path
        t.insert(path.substring(j,n),parent==null?t.root:parent,value);
        return true;
    }

    public int get(String path) {
        Node cur = t.search(path,t.root);
        return cur==null?-1:cur.value;
    }
}
