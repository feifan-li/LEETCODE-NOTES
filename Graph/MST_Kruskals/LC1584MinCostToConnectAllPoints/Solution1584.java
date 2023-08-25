package Graph.MST_Kruskals.LC1584MinCostToConnectAllPoints;

import java.util.ArrayList;
import java.util.Collections;

public class Solution1584 {
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
            int rx = find(x), ry = find(y);
            if(rx==ry)  return;
            if(size[rx]<=size[ry]){
                parent[rx] = ry;
                size[ry] += size[rx];
            }else{
                parent[ry] = rx;
                size[rx] += size[ry];
            }
            count--;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        ArrayList<int[]> edges = new ArrayList<>();
        for(int i=0;i<points.length;++i){
            for(int j=i+1;j<points.length;++j){
                edges.add(new int[]{i,j,Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1])});
            }
        }
        int ans = 0;
        UnionFind uf = new UnionFind(points.length);
        Collections.sort(edges,(a, b)->(a[2]-b[2]));
        for(int[] e:edges){
            if(uf.find(e[0])!=uf.find(e[1])){
                uf.union(e[0],e[1]);
                ans += e[2];
            }
        }
        return ans;
    }
}
