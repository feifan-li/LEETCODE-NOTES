package Graph.MST_Kruskals.LC1489FindCriticalAndSudoCriticalEdgesInMST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution1489 {
    class UnionFind{
        int[] parent;
        int[] size;
        int count;
        UnionFind(int n){
            this.parent = new int[n];
            this.size = new int[n];
            this.count = n;
            for(int i=0;i<n;++i){
                this.parent[i] = i;
                this.size[i] = 1;
            }
        }
        int find(int x){
            while(x!=parent[x]){
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
        void union(int x,int y){
            int rootx = find(x);
            int rooty = find(y);
            if(rootx==rooty)    return;
            if(size[rootx]<size[rooty]){
                parent[rootx] = rooty;
                size[rooty] += size[rootx];
            }else{
                parent[rooty] = rootx;
                size[rootx] += size[rooty];
            }
            count--;
        }
        int getCount(){
            return this.count;
        }
    }
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<Integer>());//critical edges represented by edge id
        ans.add(new ArrayList<Integer>());//pseudo-critical edges represented by edge id
        ArrayList<int[]> edgesWithId = new ArrayList<int[]>();
        for(int i=0;i<edges.length;++i){
            edgesWithId.add(new int[]{i,edges[i][0],edges[i][1],edges[i][2]});
        }
        Collections.sort(edgesWithId,(a, b)->(a[3]-b[3]));//sort edges by weight increasingly
        ArrayList<int[]> MST = Kruskals(n,edgesWithId,new int[]{-1,0,0,0},new int[]{-1,0,0,0});
        int weight = weightOfMST(MST);
        //only edges in MST can be critical
        boolean[] critical = new boolean[200];
        for(int[] edge:MST){
            if(weightOfMST(Kruskals(n,edgesWithId,new int[]{-1,0,0,0},edge))>weight){
                ans.get(0).add(edge[0]);
                critical[edge[0]] = true;
            }
        }
        for(int[] edge:edgesWithId){
            if(!critical[edge[0]] && weightOfMST(Kruskals(n,edgesWithId,edge,new int[]{-1,0,0,0}))==weight){
                ans.get(1).add(edge[0]);
            }
        }
        return ans;
    }
    public ArrayList<int[]> Kruskals(int n,ArrayList<int[]> edges,int[] mandatoryEdge, int[] removedEdge){
        /** return edges in MST*/
        UnionFind uf = new UnionFind(n);
        ArrayList<int[]> MST = new ArrayList<>();
        if(mandatoryEdge[0]!=-1){
            uf.union(mandatoryEdge[1],mandatoryEdge[2]);
            MST.add(mandatoryEdge);
        }
        for(int[] e:edges){
            if(e[0]!=removedEdge[0] && uf.find(e[1])!=uf.find(e[2])){
                uf.union(e[1],e[2]);
                MST.add(e);
            }
        }
        return uf.getCount()>1?null:MST;
    }
    public int weightOfMST(ArrayList<int[]> edges){
        /** return weight sum of MST*/
        if(edges==null)  return Integer.MAX_VALUE;
        int sum = 0;
        for(int[] e:edges)  sum += e[3];
        return sum;
    }
}
