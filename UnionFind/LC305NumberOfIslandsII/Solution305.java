package UnionFind.LC305NumberOfIslandsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution305 {
    public class UnionFind{
        private int[] parent;
        private int[] size;
        private int count;
        public UnionFind(int n){
            parent = new int[n];
            Arrays.fill(parent,-1);
            size = new int[n];
            count = 0;
        }
        public int find(int x){
            if(parent[x]==-1)   return -1;
            while(x!=parent[x]){
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return parent[x];
        }
        public void union(int x,int y){
            int rootx = find(x);
            int rooty = find(y);
            if(rootx==rooty)    return;
            if(rootx==-1 || rooty==-1)  return;
            if(size[rootx]<=size[rooty]){
                parent[rootx] = rooty;
                size[rooty] += size[rootx];
            }else{
                parent[rooty] = rootx;
                size[rootx] += size[rooty];
            }
            count--;
        }
        public void add(int id){
            parent[id] = id;
            size[id] ++;
            count++;
        }
        public int getCount(){
            return count;
        }
    }
    public int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        UnionFind uf = new UnionFind(m*n);
        for(int[] pos:positions){
            int id = pos[0]*n+pos[1];
            if(uf.find(id)!=-1){//this position is repeated
                ans.add(uf.getCount());
                continue;
            }
            uf.add(id);
            for(int[] dir:dirs){
                if(pos[0]+dir[0]>=0 && pos[0]+dir[0]<m && pos[1]+dir[1]>=0 && pos[1]+dir[1]<n){
                    uf.union(id,(pos[0]+dir[0])*n+pos[1]+dir[1]);
                }
            }
            ans.add(uf.getCount());
        }
        return ans;
    }
}
