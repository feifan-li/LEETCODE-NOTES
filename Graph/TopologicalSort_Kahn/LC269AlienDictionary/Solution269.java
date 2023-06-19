package Graph.TopologicalSort_Kahn.LC269AlienDictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution269 {
    public String alienOrder(String[] words) {
        HashMap<Character, HashSet<Character>> graph = new HashMap<>();
        int[] in = new int[26];
        int cnt = 0;
        for(String word:words){
            for(int i=0;i<word.length();++i){
                if(in[word.charAt(i)-'a']==0){
                    in[word.charAt(i)-'a'] = 1;
                    cnt++;
                }
            }
        }
        for(int i=0;i<words.length-1;++i){
            if(words[i].length()>words[i+1].length() && words[i].startsWith(words[i+1]))   return "";
            for(int j=0;j<Math.min(words[i].length(),words[i+1].length());++j){
                if(words[i].charAt(j)!=words[i+1].charAt(j)){
                    if(!graph.containsKey(words[i].charAt(j)))  graph.put(words[i].charAt(j),new HashSet<Character>());
                    if(graph.get(words[i].charAt(j)).add(words[i+1].charAt(j)))  in[words[i+1].charAt(j)-'a']++;
                    break;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for(int i=0;i<26;++i){
            if(in[i]==1)    queue.offer((char)(i+'a'));
        }
        while(!queue.isEmpty()){
            Character u = queue.poll();
            res.append(u);
            for(Character v:graph.containsKey(u)?graph.get(u):new HashSet<Character>()){
                if(--in[v-'a']==1)  queue.offer(v);
            }
        }
        return res.length()==cnt?res.toString():"";
    }
}
