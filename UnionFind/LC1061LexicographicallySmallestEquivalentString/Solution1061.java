package UnionFind.LC1061LexicographicallySmallestEquivalentString;

public class Solution1061 {
    static class MyUnionFind{
        private int count;
        private int[] parent;
        public MyUnionFind(int n){
            this.count = n;
            parent = new int[n];
            for(int i=0;i<parent.length;++i){
                parent[i] = i;
            }
        }
        public int find(int x){
            while(parent[x]!=x){
                parent[x] = parent[parent[x]];
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
            if(rootP<rootQ){
                parent[rootQ] = rootP;
            }else{
                parent[rootP] = rootQ;
            }
            this.count--;
        }
        public int count(){return this.count;}
    }


    public static String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length();
        MyUnionFind uf = new MyUnionFind(26);
        for(int i=0;i<n;++i){
            uf.union(s1.charAt(i)-'a',s2.charAt(i)-'a');
        }
        int m = baseStr.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<m;++i){
            char equal = (char)('a'+uf.find(baseStr.charAt(i)-'a'));
            sb.append(equal);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(smallestEquivalentString("parker","morris","parser"));
        System.out.println(smallestEquivalentString("hello","world","hold"));
        System.out.println(smallestEquivalentString("leetcode","programs","sourcecode"));
    }
}
