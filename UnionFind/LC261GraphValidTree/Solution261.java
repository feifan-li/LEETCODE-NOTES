package UnionFind.LC261GraphValidTree;

public class Solution261 {
    class UnionFind{
        int count;
        int[] parent;
        int[] size;
        UnionFind(int n){
            this.count = n;
            this.parent = new int[n];
            this.size = new int[n];
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
            this.count--;
        }
        int getCount(){
            return this.count;
        }
    }
    public boolean validTree(int n, int[][] edges) {
        int m = edges.length;
        if(n-1!=m)  return false;
        UnionFind uf = new UnionFind(n);
        for(int[] e:edges){
            uf.union(e[0],e[1]);
        }
        System.out.println(uf.getCount());
        return uf.getCount()==1;
    }
}
