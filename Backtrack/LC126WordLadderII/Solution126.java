package Backtrack.LC126WordLadderII;

import java.util.*;

public class Solution126 {
    public static List<List<String>> res = new LinkedList<>();
    public static List<List<String>> findLadders(String begin, String end, List<String> wordList) {
        HashMap<String,LinkedList<String>> dag = new HashMap<>();
        for(int i=0;i<wordList.size();++i){
            dag.put(wordList.get(i),new LinkedList<String>());
        }
        if(!dag.containsKey(begin)){
            dag.put(begin,new LinkedList<String>());
        }
        //dag will be built with BFS:
        Queue<String> q = new LinkedList<>();
        q.offer(begin);
        boolean foundEnd = false;
        HashSet<String> unvisited = new HashSet<>(wordList);
        unvisited.remove(begin);
        while(!q.isEmpty()){
            int size = q.size();
            HashSet<String> visitedByCurLevel = new HashSet<>();
            //cur level
            for(int cnt = 0;cnt<size;++cnt){
                String cur = q.poll();//word of cur level
                //explore a new level
                for(int i = 0;i<wordList.size();++i){
                    String newWord = wordList.get(i);
                    if(unvisited.contains(newWord)){
                        if(canTransform(cur,newWord)){
                            if(visitedByCurLevel.add(newWord)){
                                q.offer(newWord);//only offer newWord once
                            }
                            dag.get(newWord).add(cur);
                            if(!foundEnd && newWord.equals(end))    foundEnd = true;
                        }
                    }
                }
            }
            if(foundEnd) break;//dag is ready to use
            unvisited.removeAll(visitedByCurLevel);
        }
        if(!foundEnd) return res;
        dfs(end,begin,new LinkedList<String>(),dag);
        return res;
    }
    private static void dfs(String cur,String target,List<String> curList,HashMap<String,LinkedList<String>> dag){
        curList.add(0,cur);
        if(cur.equals(target)){
            res.add(new ArrayList<>(curList));
            curList.remove(0);
            return;
        }
        if(dag.containsKey(cur)){
            for(String next:dag.get(cur)){
                dfs(next,target,curList,dag);
            }
        }
        curList.remove(0);
    }
    private static boolean canTransform(String s,String t){
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

    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        findLadders("hit","cog",wordList);
        System.out.println(res);
    }
}
