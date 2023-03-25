package UnionFind.LC2492MinScoreOfAPathBetweenTwoCities;

public class Solution2492 {
    //only care the connected component S which contains both city 1 and city n
    //there is always a path between 1 and n, it's okay that such path visits a same node in finite times
    //therefore, can visit all edges within S, BFS/DFS cannot do this ...
    //union find works
    private class UnionFind{
        private int count;
        private int[] parent;
        private int[] size;
        public int[] minScore;
        public UnionFind(int n){
            this.count = n;
            this.parent = new int[n];
            this.size = new int[n];
            this.minScore = new int[n];
            for(int i=0;i<n;++i){
                parent[i] = i;
                size[i] = 1;
                minScore[i] = Integer.MAX_VALUE;
            }
        }
        public int find(int x){
            while(parent[x]!=x){
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
        public void union(int x,int y,int score){
            int rootx = find(x);
            int rooty = find(y);
            if(rootx==rooty){
                minScore[rootx] = Math.min(minScore[rootx],score);
                return;
            }else if(size[rootx]<size[rooty]){
                //add small tree to big tree
                parent[rootx] = rooty;
                size[rooty] += size[rootx];
                minScore[rooty] = Math.min(minScore[rooty],Math.min(minScore[rootx],score));
            }else{
                //add small tree to big tree
                parent[rooty] = rootx;
                size[rootx] += size[rooty];
                minScore[rootx] = Math.min(minScore[rootx],Math.min(minScore[rooty],score));
            }
            count--;
        }
        public int getCount(){
            return this.count;
        }
    }
    public int minScore(int n, int[][] roads) {
        UnionFind uf = new UnionFind(n+1);
        for(int[] road:roads) uf.union(road[0],road[1],road[2]);
        int root = uf.find(1);
        assert root==uf.find(n):"uf.find(1)!=uf.find(n)";
        return uf.minScore[root];
    }
}
