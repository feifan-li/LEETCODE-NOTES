package Trie_PrefixTree.LC212WordSearchII;

import java.util.ArrayList;
import java.util.List;

public class Solution212_2 {
    class Trie{
        class TrieNode{
            int pass;
            int end;
            TrieNode[] nexts;
            TrieNode(){
                this.pass = 0;
                this.end = 0;
                this.nexts = new TrieNode[26];
            }
        }
        TrieNode root;
        Trie(){this.root = new TrieNode();}
        void insert(String word){
            TrieNode cur = root;
            cur.pass++;
            for(int i=0;i<word.length();++i){
                int path = word.charAt(i)-'a';
                if(cur.nexts[path]==null)   cur.nexts[path] = new TrieNode();
                cur = cur.nexts[path];
                cur.pass++;
            }
            cur.end++;
        }
        void delete(String word){
            TrieNode cur = root;
            cur.pass--;
            for(int i=0;i<word.length();++i){
                int path = word.charAt(i)-'a';
                if(--cur.nexts[path].pass==0){
                    cur.nexts[path] = null;
                    return;
                }
                cur = cur.nexts[path];
            }
            cur.end--;
        }
        boolean search(String word){
            TrieNode cur = root;
            for(int i=0;i<word.length();++i){
                int path = word.charAt(i)-'a';
                if(cur.nexts[path]==null)   return false;
                cur = cur.nexts[path];
            }
            return cur.end>=1;
        }
        boolean prefix(String word){
            TrieNode cur = root;
            for(int i=0;i<word.length();++i){
                int path = word.charAt(i)-'a';
                if(cur.nexts[path]==null)   return false;
                cur = cur.nexts[path];
            }
            return cur.pass>=1;
        }
    }
    public Trie t = new Trie();
    public int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public List<String> res = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        for(String word:words)  t.insert(word);
        boolean[][] visited = new boolean[board.length][board[0].length];
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<board.length;++i){
            for(int j=0;j<board[0].length;++j){
                sb.append(board[i][j]);
                visited[i][j] = true;
                backtrack(board,visited,sb,i,j,board.length,board[0].length);
                visited[i][j] = false;
                sb.deleteCharAt(0);
            }
        }
        return res;
    }
    public void backtrack(char[][] board,boolean[][] visited, StringBuilder sb,int i,int j,int m,int n){
        if(!t.prefix(sb.toString()))    return;
        else if(t.search(sb.toString())){
            res.add(sb.toString());
            t.delete(sb.toString());
        }
        for(int[] dir:dirs){
            if(i+dir[0]>=0 && i+dir[0]<m && j+dir[1]>=0 && j+dir[1]<n && !visited[i+dir[0]][j+dir[1]]){
                visited[i+dir[0]][j+dir[1]] = true;
                sb.append(board[i+dir[0]][j+dir[1]]);
                backtrack(board,visited,sb,i+dir[0],j+dir[1],m,n);
                sb.deleteCharAt(sb.length()-1);
                visited[i+dir[0]][j+dir[1]] = false;
            }
        }
    }
}
