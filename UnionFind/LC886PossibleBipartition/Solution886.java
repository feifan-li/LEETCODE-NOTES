package UnionFind.LC886PossibleBipartition;

public class Solution886 {
    //反向点+并查集
    public static class UnionFind{
        public int count;
        public int[] parent;
        public int[] size;

        public UnionFind(int n){
            this.count = n;
            this.parent = new int[n];
            this.size = new int[n];
            for(int i=0;i<n;++i){
                parent[i] = i;
                size[i] = 1;
            }
        }
        public int find(int x){
            while(x!=parent[x]){
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
        public boolean connected(int x,int y){
            return find(x) == find(y);
        }
        public void union(int x,int y){
            int rootx = find(x);
            int rooty = find(y);
            if(rootx==rooty) return;
            else{
                if(size[rootx]>=size[rooty]){
                    parent[rooty] = rootx;
                    size[rootx]+=size[rooty];
                }else{
                    parent[rootx] = rooty;
                    size[rooty]+=size[rootx];
                }
                --count;
            }
        }
        public int getCount(){
            return this.count;
        }
    }
    public static boolean possibleBipartition(int n, int[][] dislikes) {
        UnionFind uf = new UnionFind(2*n+1);
        for(int[] i:dislikes){
            if(uf.connected(i[0],i[1])) return false;
            uf.union(i[0],i[1]+n);uf.union(i[1],i[0]+n);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(possibleBipartition(5,new int[][]{{1,2},{2,3},{3,4},{4,5},{1,5}}));
    }
}
