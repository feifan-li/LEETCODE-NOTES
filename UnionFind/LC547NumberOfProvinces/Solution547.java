package UnionFind.LC547NumberOfProvinces;

public class Solution547 {
    public class UnionFind{
        private int count;
        private int[] parent;
        private int[] size;
        public UnionFind(int count){
            this.count = count;
            parent = new int[count];
            size = new int[count];
            for(int i=0;i<count;++i){
                parent[i] = i;
                size[i] = 1;
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
            int rootx = find(x);
            int rooty = find(y);
            return rootx==rooty;
        }
        public void union(int x,int y){
            int rootx = find(x);
            int rooty = find(y);
            if(rootx==rooty) return;
            if(size[rootx]<=size[rooty]){
                parent[rootx] = rooty;
                size[rooty] += size[rootx];
            }else{
                parent[rooty] = rootx;
                size[rootx] += size[rooty];
            }
            this.count--;
        }
        public int getCount(){
            return this.count;
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n+1);
        for(int i=0;i<n;++i){
            for(int j=i+1;j<n;++j){
                if(isConnected[i][j]==1) uf.union(i+1,j+1);
            }
        }
        return uf.getCount()-1;
    }
}
