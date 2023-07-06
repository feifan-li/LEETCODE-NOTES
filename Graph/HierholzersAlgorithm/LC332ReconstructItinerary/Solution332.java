package Graph.HierholzersAlgorithm.LC332ReconstructItinerary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Solution332 {
    public List<String> ans = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> g = new HashMap<>();
        for(List<String> ticket:tickets){
            if(!g.containsKey(ticket.get(0)))   g.put(ticket.get(0),new PriorityQueue<String>());
            if(!g.containsKey(ticket.get(1)))   g.put(ticket.get(1),new PriorityQueue<String>());
            g.get(ticket.get(0)).add(ticket.get(1));
        }
        dfs("JFK",g);
        return ans;
    }
    public void dfs(String src,HashMap<String,PriorityQueue<String>> g){
        while(!g.get(src).isEmpty())    dfs(g.get(src).poll(),g);
        ans.add(0,src);
    }
}
