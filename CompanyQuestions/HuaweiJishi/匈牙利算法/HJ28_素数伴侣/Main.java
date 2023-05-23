package CompanyQuestions.HuaweiJishi.匈牙利算法.HJ28_素数伴侣;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static class Info{
        public ArrayList<Integer> potentialPartner;//should not be modified once generated
        public ArrayList<Boolean> visited;
        public Info(){
            this.potentialPartner = new ArrayList<>();
            this.visited = new ArrayList<>();
        }
        //for debugging
        @Override
        public String toString() {
            return "Info{" +
                    "potentialPartner=" + potentialPartner.toString() +
                    ", visited=" + visited.toString() +
                    '}';
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        for(int i=0;i<n;++i){
//            nums[i] = in.nextInt();
//        }
        int[] nums1 = new int[]{1507,6611,20966,571,1023,9390,16632,16742,12152,18621,4670,25368,15333,7461,12737,24979,10819,1505,13802,20395,6112,18161,23373,9154,14116,24391,27280,27686};
        int[] nums2 = new int[]{
                1882,29009,29704,13735,13534,10803,5667,17942,24890,19030,15220,14454,18037,21,25487,12592,18226,4721,25050,21565,3439,25324,3450,
                9956,15744,17645,1807,26133,1638,25781,801,15617,20563,7736,3154,2137,191,8287,16283,19519,1980,17779,20114,14364,7568,20463,2360,
                6745,16110,23600,13361,13644,25906,18447,13329,27098,28924,20865
        };
        int[] nums = new int[]{
                25606,9056,17585,9754,29060,978,3156,9997,13286,3419,18853,5325,1580,292,24811,943,18898,6507,6270,7296,15538,20251,28206,10001,818,
                3953,993,15744,8489,20700,18853,24969
        };
//        Arrays.sort(nums);
        ArrayList<Integer> odds = new ArrayList<>();
        ArrayList<Integer> evens = new ArrayList<>();
        int maxOdd = 0, maxEven = 0;
        for(int num:nums){
            if(num%2==0){
                evens.add(num);
                maxEven = Math.max(num,maxEven);
            }else{
                odds.add(num);
                maxOdd = Math.max(num,maxOdd);
            }
        }
        System.out.println(odds);
        System.out.println(evens);
        boolean[] notPrime = new boolean[maxEven+maxOdd+2];
        for(int i=2;i*i<=maxEven+maxOdd;++i){
            if(!notPrime[i]){
                for(int j = i*i;j<=maxEven+maxOdd;j=j+i){
                    notPrime[j] = true;
                }
            }
        }
        if(odds.size()<=evens.size()){
            int cnt = HungarianAlgorithm(notPrime,odds,evens);
            System.out.println(cnt);
        }else{
            int cnt = HungarianAlgorithm(notPrime,evens,odds);
            System.out.println(cnt);
        }
    }
    private static int GaleShapley(boolean[] notPrime,ArrayList<Integer> S,ArrayList<Integer> T){
        int m = S.size();
        int n = T.size();
        int[] matchWithT = new int[m];
        int[] matchWithS = new int[n];
        Arrays.fill(matchWithT,-1);
        Arrays.fill(matchWithS,-1);
        System.out.println(S);
        System.out.println(T);
        ArrayList<Info> map = new ArrayList<>();
        for(int i=0;i<m;++i){
            map.add(new Info());
            for(int j=0;j<n;++j){
                if(!notPrime[S.get(i)+T.get(j)]){
                    map.get(i).potentialPartner.add(j);
                    map.get(i).visited.add(false);
                }
            }
        }
        assert map.size()==m;
        System.out.println(map);
        int max = m, pairs = 0;
        while(pairs<max){
            for(int i=0;i<m;++i){
                Info curM = map.get(i);
                if(matchWithT[i]!=-1){
                    continue;
                }else if(curM.potentialPartner==null || curM.potentialPartner.size()==0){//only reach here once
                    max--;
                    matchWithT[i] = Integer.MAX_VALUE;
                    continue;
                }else if(matchWithT[i]==-1){
                    int nextNToVisit = -1;//an index in N
                    for(int j=0;j<curM.visited.size();++j){
                        if(curM.visited.get(j)==false){
                            nextNToVisit = curM.potentialPartner.get(j);
                            curM.visited.set(j,true);
                            break;
                        }
                    }
                    if(nextNToVisit==-1){
                        max--;
                        matchWithT[i] = Integer.MAX_VALUE;
                        continue;
                    }
                    if(matchWithS[nextNToVisit]==-1){
                        matchWithS[nextNToVisit] = i;
                        matchWithT[i] = nextNToVisit;
                        pairs++;
                    }else{
                        int previousM = matchWithS[nextNToVisit];
                        matchWithS[nextNToVisit] = i;
                        matchWithT[i] = nextNToVisit;
                        matchWithT[previousM] = -1;
                        //pairs is not changed
                    }
                }
            }
        }
        System.out.println(map);
        return pairs;
    }
    private static int HungarianAlgorithm(boolean[] notPrime,ArrayList<Integer> S,ArrayList<Integer> T){
        int m = S.size();
        int n = T.size();
        int[] matchWithS = new int[n];
        Arrays.fill(matchWithS,-1);
        ArrayList<Info> map = new ArrayList<>();
        for(int i=0;i<m;++i){
            map.add(new Info());
            for(int j=0;j<n;++j){
                if(!notPrime[S.get(i)+T.get(j)]){
                    map.get(i).potentialPartner.add(j);
                }
            }
        }
        assert map.size()==m;
        int pairs = 0;
        for(int i=0;i<m;++i){
            boolean[] visited = new boolean[n];
            if(matchToNext(visited,matchWithS,map,i))    pairs++;
        }
        return pairs;
    }
    private static boolean matchToNext(boolean[] visited,int[] matchWithS,ArrayList<Info> map, int i){
        for(int j=0;j<map.get(i).potentialPartner.size();++j){
            if(visited[map.get(i).potentialPartner.get(j)]==false){
                int nextT = map.get(i).potentialPartner.get(j);//an index in T
                visited[nextT] = true;
                if(matchWithS[nextT]==-1 || matchToNext(visited,matchWithS,map,matchWithS[nextT])){
                    matchWithS[nextT] = i;
                    return true;
                }
            }
        }
        return false;
    }
}
