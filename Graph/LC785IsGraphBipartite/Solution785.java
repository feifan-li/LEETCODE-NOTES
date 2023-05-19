package Graph.LC785IsGraphBipartite;

import java.util.Arrays;

public class Solution785 {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];//(un)colored means (un)visited
        Arrays.fill(color,-1);
        for(int i=0;i<n;++i){//need to make sure all nodes are colored,even when graph is unconnected
            if(color[i]==-1){
                int[] q = new int[101];
                int qhead = 0,qtail = 0;
                color[i] = 0;
                q[qtail] = i;
                while(qtail>=qhead){
                    int size = qtail-qhead+1;
                    for(int cnt=0;cnt<size;++cnt){
                        int u = q[qhead++];
                        for(int v:graph[u]){
                            if(color[v]==-1){
                                color[v] = color[u]^1;
                                q[++qtail] = v;
                            }else if(color[v]==color[u]){
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
