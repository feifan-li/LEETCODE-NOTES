package Backtrack.LC212WordSearchII;

import java.util.LinkedList;
import java.util.List;

public class Solution212 {
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
                node.pass++;
            }
            node.end++;
        }
        public boolean search(String word){
            char[] str = word.toCharArray();
            Node node = root;
            for(int i=0;i<str.length;++i){
                int path = str[i]-'a';
                if(node.nexts[path]==null) return false;
                node = node.nexts[path];
            }
            return node.end>=1;
        }
        public boolean prefix(String word){
            char[] str = word.toCharArray();
            Node node = root;
            for(int i=0;i<str.length;++i){
                int path = str[i]-'a';
                if(node.nexts[path]==null) return false;
                node = node.nexts[path];
            }
            return node.pass>=1;
        }
        public void delete(String word){
            char[] str = word.toCharArray();
            //user need to make sure that word is existing
            Node node = root;
            node.pass--;
            for(int i=0;i<str.length;++i){
                int path = str[i]-'a';
                if(--node.nexts[path].pass==0){
                    node.nexts[path]=null;
                    return;
                }
                node = node.nexts[path];
            }
            node.end--;
        }
    }
    public List<String> ans = new LinkedList<>();
    public Trie t = new Trie();
    public List<String> findWords(char[][] board, String[] words) {
        for(String s:words) t.insert(s);
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                dfs(board,new boolean[m][n],new StringBuilder(),i,j,m,n);
            }
        }
        return ans;
    }
    public void dfs(char[][] board,boolean[][] visited, StringBuilder sb,int row,int col,int m,int n){
        sb = sb.append(board[row][col]);
        visited[row][col] = true;
        if(!t.prefix(sb.toString())){
            sb.deleteCharAt(sb.length()-1);
            visited[row][col] = false;
            return;
        }else if(t.search(sb.toString())){
            ans.add(sb.toString());
            t.delete(sb.toString());
        }
        if(row+1<m && col<n && !visited[row+1][col]) dfs(board,visited,sb,row+1,col,m,n);
        if(row-1>=0 && col<n && !visited[row-1][col]) dfs(board,visited,sb,row-1,col,m,n);
        if(row<m && col+1<n && !visited[row][col+1]) dfs(board,visited,sb,row,col+1,m,n);
        if(row<m && col-1>=0 && !visited[row][col-1]) dfs(board,visited,sb,row,col-1,m,n);

        sb.deleteCharAt(sb.length()-1);
        visited[row][col] = false;
    }
}
