package BFS.LC1376TimeNeededToInformAllEmployees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1376 {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;++i)    graph.add(new ArrayList<>());
        for(int i=0;i<n;++i){
            if(manager[i]!=-1){
                graph.get(manager[i]).add(i);
            }
        }
        int time = Integer.MIN_VALUE;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{headID,0});//node and the timestamp it receives the message
        while(!q.isEmpty()){
            int[] leader = q.poll();
            time = Math.max(time,leader[1]);
            for(int sub:graph.get(leader[0])){
                q.offer(new int[]{sub,leader[1]+informTime[leader[0]]});
            }
        }
        return time;
    }
}
