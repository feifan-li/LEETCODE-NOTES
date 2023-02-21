package UnionFind.LC721AccountsMerge;

import java.util.*;
//合并，去重，排序
public class Solution721 {
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
                if(size[rootx]>=size[rooty]){//！！！！！！//
                    parent[rooty] = rootx;
                    size[rootx] += size[rooty];
                }else{
                    parent[rootx] = rooty;
                    size[rooty] += size[rootx];
                }
                --count;
            }
        }
        public int getCount(){
            return this.count;
        }
    }
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int accountNum = accounts.size();
        UnionFind uf = new UnionFind(accountNum);
        HashMap<String,Integer> emailToId = new HashMap<>();//email to account id
        HashMap<String,String> emailToName = new HashMap<>();//email to account name
        for(int i=0;i<accountNum;++i){
            List<String> account = accounts.get(i);
            String name = account.get(0);
            for(int j=1;j<account.size();++j){
                String email = account.get(j);
                if(!emailToId.containsKey(email)) {
                    emailToId.put(email,i);
                    emailToName.put(email,name);
                }
                else uf.union(emailToId.get(email),i);
            }
        }
        List<HashSet<String>> emailLists = new LinkedList<>();//remove duplicates
        for(int i=0;i<accountNum;++i){
            emailLists.add(new HashSet<>());
        }
        for(int i=0;i<accountNum;++i){
            List<String> account = accounts.get(i);
            if(i==uf.find(i)){
                for(int j=1;j<account.size();++j){
                    emailLists.get(i).add(account.get(j));
                }
            }else{
                int root = uf.find(i);
                for(int j=1;j<account.size();++j){
                    if(emailToId.get(account.get(j)) == i) emailLists.get(root).add(account.get(j));
                }
            }
        }

        List<List<String>> res = new ArrayList<>();
        for(HashSet<String> list: emailLists){
            if(list.size()>0){//remove empty list
                res.add(new ArrayList<>());
                List<String> listToString = new ArrayList<>(list);
                Collections.sort(listToString);

                String name = emailToName.get(listToString.get(0));
                res.get(res.size()-1).add(name);

                for(int i=0;i<list.size();++i){
                    res.get(res.size()-1).add(listToString.get(i));
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {
        List<List<String>> test1 = new ArrayList<>();
        test1.add(new ArrayList<String>(Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com")));
        test1.add(new ArrayList<String>(Arrays.asList("John","johnsmith@mail.com","john00@mail.com")));
        test1.add(new ArrayList<String>(Arrays.asList("Mary","mary@mail.com")));
        test1.add(new ArrayList<String>(Arrays.asList("John","johnnybravo@mail.com")));

        System.out.println(accountsMerge(test1));

        List<List<String>> test2 = new ArrayList<>();
        test2.add(new ArrayList<String>(Arrays.asList("Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co")));
        test2.add(new ArrayList<String>(Arrays.asList("Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co")));
        test2.add(new ArrayList<String>(Arrays.asList("Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co")));
        test2.add(new ArrayList<String>(Arrays.asList("Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co")));
        test2.add(new ArrayList<String>(Arrays.asList("Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co")));

        System.out.println(accountsMerge(test2));

        List<List<String>> test3 = new ArrayList<>();
        test3.add(new ArrayList<String>(Arrays.asList("Alex","Alex5@m.co","Alex4@m.co","Alex0@m.co")));
        test3.add(new ArrayList<String>(Arrays.asList("Ethan","Ethan3@m.co","Ethan3@m.co","Ethan0@m.co")));
        test3.add(new ArrayList<String>(Arrays.asList("Kevin","Kevin4@m.co","Kevin2@m.co","Kevin2@m.co")));
        test3.add(new ArrayList<String>(Arrays.asList("Gabe","Gabe0@m.co","Gabe3@m.co","Gabe2@m.co")));
        test3.add(new ArrayList<String>(Arrays.asList("Gabe","Gabe3@m.co","Gabe4@m.co","Gabe2@m.co")));

        System.out.println(accountsMerge(test3));

    }
}
