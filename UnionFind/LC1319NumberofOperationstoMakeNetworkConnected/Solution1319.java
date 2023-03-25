package UnionFind.LC1319NumberofOperationstoMakeNetworkConnected;

import java.util.ArrayList;
import java.util.List;

public class Solution1319 {
    public static class UnionFind{
        public int count;
        public int[] parent;
        public int[] size;
        public int[] edges;
        public UnionFind(int n){
            this.count = n;
            parent = new int[n];
            size = new int[n];
            edges = new int[n];
            for(int i=0;i<n;++i){
                parent[i] = i;
                size[i] = 1;
                edges[i] = 0;
            }
        }
        public int find(int x){
            while(parent[x]!=x){
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
        public void union(int x,int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY){
                edges[rootX] += 1;
                return;
            }
            //add small tree to big tree;
            if(size[rootX]<size[rootY]){
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
                edges[rootY] += edges[rootX]+1;
            }else{
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
                edges[rootX] += edges[rootY]+1;
            }
            count--;
        }
        public int getCount(){
            return this.count;
        }
    }
    public static int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) return -1;
        UnionFind uf = new UnionFind(n);
        for(int[] conn:connections) uf.union(conn[0],conn[1]);

        if(uf.getCount()==1) return 0;
        int removableCables = 0;
        int[] visitedRoot = new int[n];
        for(int i=0;i<n;++i){
            int root = uf.find(i);
            if(visitedRoot[root]++!=0){
                if(uf.edges[root]>uf.size[root]-1) {
                    removableCables += uf.edges[root] - (uf.size[root] - 1);
                    if (removableCables >= uf.getCount() - 1) return uf.getCount() - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(makeConnected(4,new int[][]{{0,1},{0,2},{1,2}}));
        System.out.println(makeConnected(6,new int[][]{{0,1},{0,2},{0,3},{1,2},{1,3}}));
        System.out.println(makeConnected(6,new int[][]{{0,1},{0,2},{0,3},{1,2}}));
        System.out.println(makeConnected(15,new int[][]{{5, 7}, {7, 9}, {1, 3}, {1, 4}, {0, 8}, {2, 11}, {5, 9}, {4, 14}, {7, 8}, {3, 10}, {9, 12}, {5, 11}, {4, 7}, {2, 4}, {2, 5}, {6, 9}, {5, 10}}));
    }
}
