package DynamicProgramming.LC279PerfectSquares;

import java.util.HashMap;

public class Solution279_1 {
    public HashMap<Integer,Integer> memo = new HashMap<>();
    public int numSquares(int n) {
        if(memo.containsKey(n)) return memo.get(n);
        if(n==0){
            memo.put(n,0);
            return 0;
        }
        if((int)(Math.sqrt(n))*(int)(Math.sqrt(n))==n){
            memo.put(n,1);
            return 1;
        }
        int min = Integer.MAX_VALUE;
        for(int i=1;i*i<=n;++i){
            min = Math.min(min,1+numSquares(n-i*i));
        }
        memo.put(n,min);
        return min;
    }
}
