package BFS.LC127WordLadder;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution127 {
    public int ladderLength(String begin, String end, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        q.offer(begin);
        boolean[] visited = new boolean[wordList.size()];
        int level = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int cnt = 0;cnt<size;++cnt){
                String cur = q.poll();
                for(int i = 0;i<wordList.size();++i){
                    if(!visited[i]){
                        String word = wordList.get(i);
                        if(canTransform(cur,word)){
                            if(word.equals(end)){
                                return level+1;
                            }
                            q.offer(word);
                            visited[i] = true;
                        }
                    }
                }
            }
            ++level;
        }
        return 0;
    }
    private boolean canTransform(String s,String t){
        if(s.length()!=t.length()) return false;
        boolean oneDifference = false;
        for(int i=0;i<s.length();++i){
            if(s.charAt(i)==t.charAt(i)){
                continue;
            }else if(s.charAt(i)!=t.charAt(i) && !oneDifference){
                oneDifference = true;
                continue;
            }else if(s.charAt(i)!=t.charAt(i) && oneDifference){
                return false;
            }
        }
        return oneDifference;
    }
}
