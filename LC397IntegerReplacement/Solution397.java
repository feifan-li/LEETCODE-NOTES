package LC397IntegerReplacement;

import java.util.HashMap;

public class Solution397 {
    public HashMap<Integer,Integer> memo = new HashMap<>();
    public int integerReplacement(int n) {
        if(n==1)    return 0;
        if(n==2)    return 1;
        if(memo.containsKey(n)) return memo.get(n);
        int ans = 0;
        if(n%2==0)  ans = 1+integerReplacement(n/2);
        else ans = Math.min(2+integerReplacement(n/2),2+integerReplacement(n/2+1));
        memo.put(n,ans);
        return ans;
    }
}
