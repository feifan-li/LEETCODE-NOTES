package UnionFind;

public class UnionFind {
    private int count;
    private int[] parent;
//    optimize: tree rooted at x has size[x] nodes
    private int[] size;
    public UnionFind(int n){ //n = |V|
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for(int i=0;i<n;++i){
            parent[i] = i;
            size[i] = 1;
        }
    }
    private int find(int x){ //        return root of node x
        while(parent[x] != x){
            //***************************//
            parent[x] = parent[parent[x]];//path compression -> decrease the tree's height (height<=3)
                                          // -> find() takes O(1), connected() takes O(1), union() takes O(1)
            //***************************//
            x = parent[x];
        }
        return x;
    }
    public boolean connected(int p,int q){
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }
    public void union(int p,int q){
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP==rootQ) return;
//        for balancing, add small tree to big tree:
//        parent[rootP] = rootQ;
        if(size[rootP] > size[rootQ]){
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }else{
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }
    public int count(){
        return this.count;
    }
}
