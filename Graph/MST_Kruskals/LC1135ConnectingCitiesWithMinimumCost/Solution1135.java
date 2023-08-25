package Graph.MST_Kruskals.LC1135ConnectingCitiesWithMinimumCost;

import java.util.Arrays;

public class Solution1135 {
    //Minimum Spanning Tree - Kruskal's Algorithm
    class UnionFind{
        int[] parent;
        int[] size;
        int count;
        UnionFind(int n){
            parent = new int[n];
            size = new int[n];
            count = n;
            for(int i=0;i<n;++i){
                parent[i] = i;
                size[i] = 1;
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
            if(size[rootx]<=size[rooty]){
                parent[rootx] = rooty;
                size[rooty] += size[rootx];
            }else{
                parent[rooty] = rootx;
                size[rootx] += size[rooty];
            }
            count--;
        }
        int getCount(){
            return count;
        }
    }
    public int minimumCost(int n, int[][] conn) {
        int cost = 0;
        Arrays.sort(conn, (a, b)->(a[2]-b[2]));
        UnionFind uf = new UnionFind(n);
        for(int[] e:conn){
            if(uf.find(e[0]-1)!=uf.find(e[1]-1)){
                cost += e[2];
                uf.union(e[0]-1,e[1]-1);
            }
        }
        return uf.getCount()>1?-1:cost;
    }
}
