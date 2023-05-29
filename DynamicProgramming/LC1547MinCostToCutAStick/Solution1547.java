package DynamicProgramming.LC1547MinCostToCutAStick;

import java.util.Arrays;
import java.util.HashMap;

public class Solution1547 {
    public static int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        HashMap<String,Integer> map = new HashMap<>();
        return dp(map,cuts,0,n,0,cuts.length-1);
    }
    private static int dp(HashMap<String,Integer> map,int[] cuts,int stickStart,int stickLength,int cutLeft,int cutRight){
        if(map.containsKey(stickStart+","+stickLength)) return map.get(stickStart+","+stickLength);
        if(cutLeft>cutRight){
            map.put(stickStart+","+stickLength,0);
            return 0;
        }
        if(cutLeft==cutRight){
            map.put(stickStart+","+stickLength,stickLength);
            return stickLength;
        }
        int res = Integer.MAX_VALUE;
        for(int i=cutLeft;i<=cutRight;++i){
            int cut = cuts[i];
            int lastSmaller = lastSmallerThan(cuts,cutLeft,cutRight,cut);
            int firstGreater = firstGreaterThan(cuts,cutLeft,cutRight,cut);
            res = Math.min(res,stickLength+dp(map,cuts,stickStart,cut-stickStart,cutLeft,lastSmaller)+
                    dp(map,cuts,cut,stickLength-cut+stickStart,firstGreater,cutRight));
        }
        map.put(stickStart+","+stickLength,res);
        return res;
    }
    private static int lastSmallerThan(int[] cuts,int left,int right,int target){
        while(left<=right){
            int mid = left+(right-left)/2;
            if(cuts[mid]>target)    right = mid-1;
            else if(cuts[mid]==target)  return mid-1;
            else    left = mid+1;
        }
        return left-1;
    }
    private static int firstGreaterThan(int[] cuts,int left,int right,int target){
        while(left<=right){
            int mid = left+(right-left)/2;
            if(cuts[mid]<target)    left = mid+1;
            else if(cuts[mid]==target)  return mid+1;
            else    right = mid-1;
        }
        return right+1;
    }

    public static void main(String[] args) {
        int[] cuts = new int[]{1,3,4,5};
        System.out.println(minCost(7,cuts));
    }
}
