package Backtrack.LC797AllPathsFromSourceToTarget_DAG;

import java.util.LinkedList;
import java.util.List;

public class Solution797 {
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        int s=0,t=graph.length-1;
        list.add(s);
        backtrack(res,list,graph,s,t);
        return res;
    }
    public static void backtrack(List<List<Integer>> res,LinkedList<Integer> list,int[][] graph,int s,int t){
        if(s==t){
            res.add(new LinkedList(list));
            return;
        }
        for(int v:graph[s]){
            list.add(v);
            backtrack(res,list,graph,v,t);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}}));
        System.out.println(allPathsSourceTarget(new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}}));
    }
}
