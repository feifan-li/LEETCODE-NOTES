package UnionFind.LC1971FindIfPathExistsInGraph;

public class Solution1971 {
    public static class UnionFind{
        private int count;
        private int[] parent;
        private int[] size;
        public UnionFind(int n){
            this.count = n;
            parent = new int[n];
            size = new int[n];
            for(int i=0;i<n;++i){
                parent[i] = i;
                size[i] = 1;
            }
        }
        public int getCount(){
            return this.count;
        }
        public int find(int x){
            while(x!=parent[x]){
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
        public boolean connected(int x,int y){
            return find(x)==find(y);
        }
        public void union(int x,int y){
            int rootx = find(x);
            int rooty = find(y);
            if(rootx==rooty) return;
            else{
                if(size[rootx]>size[rooty]){
                    parent[rooty] = rootx;
                    size[rootx] += size[rooty];
                }else{
                    parent[rootx] = rooty;
                    size[rooty] += size[rootx];
                }
                --count;
            }
        }
    }
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        UnionFind uf = new UnionFind(n);
        for(int[] edge:edges){
            uf.union(edge[0],edge[1]);
        }
        return uf.connected(source,destination);
    }

    public static void main(String[] args) {
        System.out.println(validPath(3,new int[][]{{0,1},{1,2},{2,0}},0,2));
        System.out.println(validPath(6,new int[][]{{0,1},{0,2},{3,5},{5,4},{4,3}},0,5));
    }
}
