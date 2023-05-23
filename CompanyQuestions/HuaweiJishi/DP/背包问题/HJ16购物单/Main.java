package CompanyQuestions.HuaweiJishi.DP.背包问题.HJ16购物单;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int m = in.nextInt();//m < 60
        int[] cost = new int[m+1];//1-index
        int[] weight = new int[m+1];//1-index
        int[] aff = new int[m+1];//==0：主件   ！=0：主件aff[i]的附件之一
        for(int i=1;i<=m;++i){//1-index
            cost[i] = in.nextInt();
            weight[i] = in.nextInt();
            weight[i] *= cost[i];//此后最大化sigma(weight)即可
            aff[i] = in.nextInt();
        }
        //主件->该主件的附件列表(不包含主件本身)
        HashMap<Integer, ArrayList<int[]>> affMap = new HashMap<>(); //1-index
        for(int i=1;i<=m;++i){//i-index
            if(aff[i]==0 && !affMap.containsKey(i)){
                affMap.put(i,new ArrayList<int[]>());
            }else if(aff[i]!=0){
                if(!affMap.containsKey(aff[i])) affMap.put(aff[i],new ArrayList<int[]>());
                affMap.get(aff[i]).add(new int[]{cost[i],weight[i]});//(cost, weight) pair
            }
        }
        //将 affMap 转化为：主件->主件代表的分组（组内互斥）
        //vi(affMap);
        //System.out.println("----------------------");
        //HashMap<Integer, ArrayList<int[]>> groupMap = group(affMap,cost,weight,aff,N,m);
        //vi(groupMap);
        //规约为分组（组内互斥）背包问题，组号即主件号
        System.out.println(GroupPack(group(affMap,cost,weight,aff,N,m),N));
    }
    private static HashMap<Integer, ArrayList<int[]>> group(HashMap<Integer, ArrayList<int[]>> affMap, int[] cost,int[] weight,int[] aff,int V,int m){
        //HashMap<Integer, ArrayList<int[]>> groupMap = new HashMap<>();
        for(int k = 1;k<=m;++k){
            if(aff[k]==0){
                if(affMap.get(k).size()!=0){
                    //将组内成员的组合方式去重 规约为 0-1背包问题
                    ArrayList<int[]> groupMembers = ZeroOnePack(affMap.get(k),V-cost[k],cost[k],weight[k]);
                    affMap.put(k,groupMembers);
                }
                affMap.get(k).add(new int[]{cost[k],weight[k]});
            }
        }
        return affMap;
    }
    private static ArrayList<int[]> ZeroOnePack(ArrayList<int[]> affList,int V,int cost_k,int weight_k){
        /** 0-1背包 **/
        int[] dp = new int[V+1];//dp[v]:cost v, generate dp[v] max weight
        for(int[] item:affList){
            for(int v = V;v>(V/10)*10;v--){//一个常数优化
                dp[v] = Math.max(dp[v],dp[v-item[0]]+item[1]);
            }
            for(int v = (V/10)*10;v>=item[0];v = v-10){//一个常数优化
                dp[v] = Math.max(dp[v],dp[v-item[0]]+item[1]);
            }
        }
        ArrayList<int[]> ans = new ArrayList<>();
        for(int v=10;v<=V;v=v+10){//一个常数优化
            if(dp[v]!=0)    ans.add(new int[]{v+cost_k,dp[v]+weight_k});
        }
        return ans;
    }
    private static int GroupPack(HashMap<Integer, ArrayList<int[]>> map,int V){
        /** 分组背包 **/
        int[] dp = new int[V+1];
        for(Map.Entry<Integer,ArrayList<int[]>> pair:map.entrySet()){
            for(int v = V;v>(V/10)*10;v--){//一个常数优化
                for(int[] item:pair.getValue()){
                    if(v>=item[0]) dp[v] = Math.max(dp[v],dp[v-item[0]]+item[1]);
                }
            }
            for(int v = (V/10)*10;v>=0;v = v-10){//一个常数优化
                for(int[] item:pair.getValue()){
                    if(v>=item[0]) dp[v] = Math.max(dp[v],dp[v-item[0]]+item[1]);
                }
            }
        }
        return dp[V];
    }
//    private static void vi(HashMap<Integer, ArrayList<int[]>> map){
//        for(Map.Entry<Integer,ArrayList<int[]>> pair:map.entrySet()){
//            System.out.print(pair.getKey()+":  ");
//            for(int[] item:pair.getValue()){
//                System.out.print(Arrays.toString(item) +", ");
//            }
//            System.out.println();
//        }
//    }
}
