package Graph.Dijkstras.LC1514PathWithMaximumProbability;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution1514 {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        int m = edges.length;
        ArrayList<ArrayList<int[]>> g = new ArrayList<>();
        for(int i=0;i<n;++i)    g.add(new ArrayList<int[]>());
        for(int i=0;i<m;++i){
            int[] e = edges[i];
            g.get(e[0]).add(new int[]{e[1],i});//i is edge id
            g.get(e[1]).add(new int[]{e[0],i});//i is edge id
        }
        //Dijkstra's Algorithm
        double[] dist = new double[n];
        dist[start] = 1d;
        PriorityQueue<double[]> heap = new PriorityQueue<>((a, b)->Double.compare(b[1],a[1]));
        heap.offer(new double[]{start*1.0,dist[start]});
        boolean[] found = new boolean[n];
        while(!heap.isEmpty()){
            double[] u = heap.poll();
            if((int)(u[0])==end)    return u[1];
            for(int[] v:g.get((int)(u[0]))){
                if(found[v[0]]==false){
                    double curSucc = u[1]*succProb[v[1]];
                    if(curSucc > dist[v[0]]){
                        dist[v[0]] = curSucc;
                        heap.offer(new double[]{v[0]*1.0,dist[v[0]]});
                    }
                }
            }
            found[(int)(u[0])] = true;
        }
        return dist[end];
    }
}
