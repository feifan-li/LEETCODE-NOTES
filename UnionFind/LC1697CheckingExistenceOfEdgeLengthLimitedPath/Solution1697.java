package UnionFind.LC1697CheckingExistenceOfEdgeLengthLimitedPath;

import java.util.Arrays;

public class Solution1697 {
        class UnionFind{
            private int[] parent;
            private int[] size;
            private int count;
            public UnionFind(int n){
                parent = new int[n];
                size = new int[n];
                for(int i=0;i<n;++i){
                    parent[i] = i;
                    size[i] = 1;
                }
                count = n;
            }
            public int find(int x){
                while(x!=parent[x]){
                    x = parent[parent[x]];
                }
                return x;
            }
            public void union(int x,int y){
                int rootx = find(x);
                int rooty = find(y);
                if(rootx==rooty) return;
                if(size[rootx]<size[rooty]){
                    parent[rootx] = rooty;
                    size[rooty] += size[rootx];
                }else{
                    parent[rooty] = rootx;
                    size[rootx] += size[rooty];
                }
                this.count--;
            }
            public boolean isConnected(int x,int y){
                return find(x) == find(y);
            }
            public int getCount(){
                return this.count;
            }
        }
        public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
            UnionFind uf = new UnionFind(n);
            boolean[] ans = new boolean[queries.length];
            Arrays.sort(edgeList,(a,b)->(a[2]-b[2]));
            int[][] sortedQueries = new int[queries.length][4];
            for(int i=0;i<queries.length;++i){
                sortedQueries[i][3] = i;
                sortedQueries[i][0] = queries[i][0];
                sortedQueries[i][1] = queries[i][1];
                sortedQueries[i][2] = queries[i][2];
            }
            Arrays.sort(sortedQueries,(a, b)->(a[2]-b[2]));
            int edgeIndex = 0;
            for(int i=0;i<sortedQueries.length;++i){
                int[] q = sortedQueries[i];
                int limit = q[2];
                while(edgeIndex<edgeList.length && edgeList[edgeIndex][2]<limit){
                    uf.union(edgeList[edgeIndex][0],edgeList[edgeIndex][1]);
                    edgeIndex++;
                }
                ans[q[3]] = uf.isConnected(q[0],q[1]);
            }
            return ans;
        }

    public static void main(String[] args) {
        /*test case 1*/
        int n = 5;
        int[][] edgeList = new int[][]{{0, 1, 10}, {1, 2, 5}, {2, 3, 9}, {3, 4, 13}};
        int[][] queries = new int[][]{{0, 4, 14}, {1, 4, 13}};
        /*test case 2*/
        //int n = 3;
        //int[][] edgeList = new int[][]{{0, 1, 2}, {1, 2, 4}, {2, 0, 8}, {1, 0, 16}};
        //int[][] queries = new int[][]{{0, 1, 2}, {0, 2, 5}};
    }
}
