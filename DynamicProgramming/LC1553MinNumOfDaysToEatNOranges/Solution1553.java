package DynamicProgramming.LC1553MinNumOfDaysToEatNOranges;

import java.util.HashMap;

public class Solution1553 {
    public static HashMap<Integer,Integer> dp = new HashMap<>();

    public static int minDays(int n) {
        System.out.println("n = "+n);
        if(n<=1) return n;
        //之所以n=0这个base case不能省略是因为当n = 2时 n/3=0 minDays(n/3)=0 !!!!!!
        if (dp.containsKey(n)) {
            return dp.get(n);
        }
        //方法一：先吃成2的倍数，再用一天的时间吃一半，剩下的查表
        int way1 = n%2 + 1 + minDays(n/2);
        //方法二：先吃成3的倍数，再用一天的时间吃掉2/3，剩下的查表
        int way2 = n%3 + 1 + minDays(n/3);
        //最终结果是天数较小的
        int ans = Math.min(way1,way2);
        dp.put(n,ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minDays(2));
    }
}
