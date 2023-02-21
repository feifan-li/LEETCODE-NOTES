package UnionFind.LC765CouplesHoldingHands;

public class Solution765 {
    public static class UnionFind{
        private int count;
        private int[] parent;
        private int[] size;
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
        public boolean connected(int p,int q){
            return find(p) == find(q);
        }
        public void union(int p,int q){
            int rootp = find(p);
            int rootq = find(q);
            if(rootp==rootq) return;
            else {
                if(size[rootp]>size[rootq]){
                    parent[rootq] = rootp;
                    size[rootp]+=size[rootq];
                }else{
                    parent[rootp] = rootq;
                    size[rootq]+=size[rootp];
                }
                count--;//!!!!!!!!!
            }
        }
        public int getCount(){
            return this.count;
        }
    }
    public static int minSwapsCouples(int[] row) {
        int persons = row.length;
        int couples = persons/2;
        UnionFind uf = new UnionFind(couples);
        for(int i=0;i<persons;i=i+2){
            uf.union(row[i]/2,row[i+1]/2);//(2,3) -> (1,1);  (2n-2,2n-1) -> (n-1,n-1); union different couples
        }
        return couples - uf.getCount();
    }

    public static void main(String[] args) {
        System.out.println(minSwapsCouples(new int[]{0,2,1,3}));
        System.out.println(minSwapsCouples(new int[]{3,2,0,1}));
    }
}
