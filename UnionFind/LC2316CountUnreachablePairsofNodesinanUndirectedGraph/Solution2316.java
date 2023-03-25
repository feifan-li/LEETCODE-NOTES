package UnionFind.LC2316CountUnreachablePairsofNodesinanUndirectedGraph;

public class Solution2316 {
    class UnionFind{
        public int count;
        public int[] parent;
        public int[] size;
        public UnionFind(int n){
            this.count = n;
            this.parent = new int[n];
            this.size = new int[n];
            for(int i=0;i<n;++i){
                this.parent[i] = i;
                this.size[i] = 1;
            }
        }
        public int find(int x){
            while(parent[x]!=x){
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
        public boolean connected(int x,int y){
            int rootX = find(x);
            int rootY = find(y);
            return rootX==rootY;
        }
        public void union(int x,int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX==rootY) return;
            //add small tree to big tree
            if(size[rootX]<size[rootY]){
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            }else{
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
            this.count--;
        }
        public int count(){return this.count;}
    }
    public long countPairs(int n, int[][] edges) {
        long ans = (long)n*(n-1);
        UnionFind uf = new UnionFind(n);
        for(int[] e:edges){uf.union(e[0],e[1]);}
        boolean[] visitedRoot = new boolean[n];
        for(int i=0;i<n;++i){
            int root = uf.find(i);
            if(!visitedRoot[root]){
                long size = (long)(uf.size[root]);
                ans = ans - size*(size-1);
                visitedRoot[root] = true;
            }
        }
        return ans>>1;
    }

    public static void main(String[] args) {
//        int n = 100000;
//        System.out.println(Long.MAX_VALUE);
//        long ans = n*(n-1);
//        System.out.println(ans);
//        long ans2 = (long)n*(n-1);
//        System.out.println(ans2);
    }
}
