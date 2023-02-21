package UnionFind.LC839SimilarStringGroups;

public class Solution839 {
    static class UnionFind{
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
        public int find(int x){
            while(x!=parent[x]){
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
        public boolean connected(int p,int q){
            return find(p)==find(q);
        }
        public void union(int p,int q){
            int rootP = find(p);
            int rootQ = find(q);
            if(rootP==rootQ) return;
            else{
                if(size[rootP]>=size[rootQ]){
                    parent[rootQ] = rootP;
                    size[rootP] += size[rootQ];
                }else{
                    parent[rootP] = rootQ;
                    size[rootQ] += size[rootP];
                }
                count--;
            }
        }
        public int getCount() {
            return this.count;
        }
    }
    public static int numSimilarGroups(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        UnionFind uf = new UnionFind(n);
        for(int i=0;i<n;++i){
            for(int j=i+1;j<n;++j){
                if(!uf.connected(i,j)){
                    int diff = 0;
                    for(int k=0;k<m;++k){
                        if(strs[i].charAt(k)!=strs[j].charAt(k)){
                            diff++;
                            if(diff>2) break;
                        }
                    }
                    if(diff==0 || diff==2) uf.union(i,j);
                }
            }
        }
        return uf.getCount();
    }

    public static void main(String[] args) {
        String[] strs1 = new String[]{"tars","rats","arts","star"};
        String[] strs2 = new String[]{"omv","ovm"};
        System.out.println(numSimilarGroups(strs1));
        System.out.println(numSimilarGroups(strs2));
    }
}
